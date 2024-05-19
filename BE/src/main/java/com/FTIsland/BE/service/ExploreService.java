package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.ExploreDTO;
import com.FTIsland.BE.entity.ReadEntity;
import com.FTIsland.BE.repository.ReadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExploreService {
    private final ReadRepository readRepository;
    public ExploreDTO explore(ExploreDTO exploreDTO){
        Optional<ReadEntity> read = readRepository.findByUserIdAndBookId(exploreDTO.getUserId(), exploreDTO.getBookId());
        ExploreDTO responseDTO = new ExploreDTO();
        if(read.isPresent()){
            responseDTO.setUserId(exploreDTO.getUserId());
            responseDTO.setBookId(exploreDTO.getBookId());
            responseDTO.setRead(true);
            responseDTO.setOffset_value(read.get().getOffset_value());
            responseDTO.setLimitNum(read.get().getLimitNum());
        } else{
            responseDTO.setUserId(exploreDTO.getUserId());
            responseDTO.setBookId(exploreDTO.getBookId());
            responseDTO.setRead(false);
            responseDTO.setOffset_value(0);
            responseDTO.setLimitNum(1);
        }
        return responseDTO;
    }
}
