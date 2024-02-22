package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.IslandBooksDTO;
import com.FTIsland.BE.dto.ReadDTO;
import com.FTIsland.BE.entity.ReadEntity;
import com.FTIsland.BE.repository.ReadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReadService {
    private final ReadRepository readRepository;

    public ReadDTO save(ReadDTO readDTO) {

        Optional<ReadEntity> byUserIdAndBookId = readRepository.findByUserIdAndBookId(readDTO.getUserId(), readDTO.getBookId());

        if(byUserIdAndBookId.isPresent()){ // 이미 해당 회원이 동화를 읽은 적이 있는 경우

            ReadEntity originEntity = byUserIdAndBookId.get();

            // request로 받은 DTO의 offset과 limit을
            Integer updateOffset = readDTO.getOffset();
            Integer updateLimit = readDTO.getLimitNum();

            // 원래 저장되어있던 entity에 update
            originEntity.setOffset(updateOffset);
            originEntity.setLimitNum(updateLimit);

            // updatedAt은 update 쿼리 발생 시 자동으로 업데이트. @UpdateTimestamp
            // originEntity.setUpdatedAt();

        } else{ // 처음 읽다가 나가서 현재 정보 저장을 처음 하는 경우
            // 새로 저장
            ReadEntity readEntity = ReadEntity.toReadEntity(readDTO);
            readRepository.save(readEntity);

            // createdAt은 create 쿼리 발생 시 자동으로 저장. @CreationTimestamp
        }
        Integer lastPage = readDTO.getOffset() * readDTO.getLimitNum();
        ReadDTO responseDTO = new ReadDTO(readDTO.getUserId(), readDTO.getBookId(), readDTO.getOffset(), readDTO.getLimitNum(), lastPage);

        return responseDTO;
    }

    public Optional<ReadEntity> findByUserIdAndBookId(Integer userId, Integer bookId) {
        Optional<ReadEntity> readEntity = readRepository.findByUserIdAndBookId(userId, bookId);
        return readEntity;
    }

    public Optional<ReadEntity> findByBookId(int nowId) {
        return readRepository.findByBookId(nowId);
    }

    public List<ReadDTO> progress(IslandBooksDTO islandBooksDTO) {
        List<ReadDTO> readDTOS = new ArrayList<>();

        // islandid에서 힌트를 얻어서 바로 검색
        int startNum = (islandBooksDTO.getIslandId() - 1) * 4 + 1;
        for(int i = 0; i < 4; i++) {
            int nowId = startNum + i;
            Optional<ReadEntity> readEntityOptional = readRepository.findByUserIdAndBookId(islandBooksDTO.getUserId(), nowId);
            if(readEntityOptional.isPresent()) {
                ReadDTO readDTO = new ReadDTO(islandBooksDTO.getUserId(), readEntityOptional.get().getBookId(),
                        readEntityOptional.get().getOffset(), readEntityOptional.get().getLimitNum(),
                        readEntityOptional.get().getOffset() * readEntityOptional.get().getLimitNum());
                readDTOS.add(readDTO);
            }
        }
        return readDTOS;
    }
}
