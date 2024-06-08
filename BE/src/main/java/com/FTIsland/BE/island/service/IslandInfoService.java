package com.FTIsland.BE.island.service;

import com.FTIsland.BE.island.dto.IslandInfoRequest;
import com.FTIsland.BE.island.dto.IslandInfoResponse;
import com.FTIsland.BE.island.entity.IslandInfoEntity;
import com.FTIsland.BE.island.repository.IslandInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IslandInfoService {

    private final IslandInfoRepository islandInfoRepository;

    @Transactional
    public IslandInfoResponse findById(IslandInfoRequest islandInfoRequest) {
        Optional<IslandInfoEntity> islandInfoEntity = islandInfoRepository.findById(islandInfoRequest.getId());
        if(islandInfoEntity.isPresent()) {
            IslandInfoResponse islandInfoResponse
                    = new IslandInfoResponse().builder().id(islandInfoEntity.get().getId()).name(islandInfoEntity.get().getName()).build();
            return islandInfoResponse;
        }
        else{
            return null;
        }
    }
}
