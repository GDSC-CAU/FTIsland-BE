package com.FTIsland.BE.service;

import com.FTIsland.BE.book.progress.dto.BookProgressRequest;
import com.FTIsland.BE.book.progress.dto.BookProgressResponse;
import com.FTIsland.BE.dto.ReadDTO;
import com.FTIsland.BE.entity.ReadEntity;
import com.FTIsland.BE.repository.ReadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReadService {
    private final ReadRepository readRepository;

    public ReadDTO save(ReadDTO readDTO) {

        Optional<ReadEntity> byUserIdAndBookId = readRepository.findByUserIdAndBookId(readDTO.getUserId(), readDTO.getBookId());

        if(byUserIdAndBookId.isPresent()){ // 이미 해당 회원이 동화를 읽은 적이 있는 경우

            ReadEntity originEntity = byUserIdAndBookId.get();

            // request로 받은 DTO의 offsetvalue과 limit을
            Integer updateoffsetvalue = readDTO.getOffset_value();
            Integer updateLimit = readDTO.getLimitNum();

            // 원래 저장되어있던 entity에 update
            originEntity.setOffset_value(updateoffsetvalue);
            originEntity.setLimitNum(updateLimit);

            // updatedAt은 update 쿼리 발생 시 자동으로 업데이트. @UpdateTimestamp
            // originEntity.setUpdatedAt();

        } else{ // 처음 읽다가 나가서 현재 정보 저장을 처음 하는 경우
            // 새로 저장
            ReadEntity readEntity = ReadEntity.toReadEntity(readDTO);
            readRepository.save(readEntity);

            // createdAt은 create 쿼리 발생 시 자동으로 저장. @CreationTimestamp
        }
        Integer lastPage = readDTO.getOffset_value() * readDTO.getLimitNum();
        ReadDTO responseDTO = new ReadDTO(readDTO.getUserId(), readDTO.getBookId(), readDTO.getOffset_value(), readDTO.getLimitNum(), lastPage);

        return responseDTO;
    }

    public Optional<ReadEntity> findByUserIdAndBookId(Integer userId, Integer bookId) {
        Optional<ReadEntity> readEntity = readRepository.findByUserIdAndBookId(userId, bookId);
        return readEntity;
    }

    public Optional<ReadEntity> findByBookId(int nowId) {
        return readRepository.findByBookId(nowId);
    }

    public List<BookProgressResponse> getProgress(BookProgressRequest bookProgressRequest) {
        List<BookProgressResponse> bookProgressResponseList = new ArrayList<>();

        for(ReadEntity readEntity : readRepository.findByUserIdAndIslandInfoEntityIslandId(bookProgressRequest.getUserId(), bookProgressRequest.getIslandId())){
            bookProgressResponseList.add(new BookProgressResponse().builder()
                    .userId(readEntity.getUserId())
                    .bookId(readEntity.getBookId())
                    .lastPage(readEntity.getOffset_value() * readEntity.getLimitNum()).build());
        }

        return bookProgressResponseList;
    }
}
