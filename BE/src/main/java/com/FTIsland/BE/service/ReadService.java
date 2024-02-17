package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.ReadDTO;
import com.FTIsland.BE.entity.ReadEntity;
import com.FTIsland.BE.repository.ReadRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReadService {
    private final ReadRepository readRepository;

    public ReadDTO save(ReadDTO readDTO) {
        Optional<ReadEntity> byUserIdAndBookId = readRepository.findByUserIdAndBookId(readDTO.getUserId(), readDTO.getBookId());

        if(byUserIdAndBookId.isPresent()){ // 이미 해당 회원이 동화를 읽은 적이 있는 경우
            ReadEntity originEntity = byUserIdAndBookId.get();

            // request로 받은 DTO의 offset과 limit을
            Integer updateOffset = readDTO.getOffset();
            Integer updateLimit = readDTO.getLimit();

            // 원래 저장되어있던 entity에 update
            originEntity.setOffset(updateOffset);
            originEntity.setLimit(updateLimit);

            // updatedAt은 update 쿼리 발생 시 자동으로 업데이트. @UpdateTimestamp
            //originEntity.setUpdatedAt();

        } else{ // 처음 읽다가 나가서 현재 정보 저장을 처음 하는 경우
            // 새로 저장
            ReadEntity readEntity = ReadEntity.toReadEntity(readDTO);
            readRepository.save(readEntity);

            // createdAt은 create 쿼리 발생 시 자동으로 저장. @CreationTimestamp
        }
        Integer lastPage = readDTO.getOffset() * readDTO.getLimit();
        ReadDTO responseDTO = new ReadDTO(readDTO.getUserId(), readDTO.getBookId(), lastPage);

        return responseDTO;
    }
}
