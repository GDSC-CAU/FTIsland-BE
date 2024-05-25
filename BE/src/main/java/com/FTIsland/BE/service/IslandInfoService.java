package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.IslandInfoDTO;
import com.FTIsland.BE.entity.IslandInfoEntity;
import com.FTIsland.BE.repository.IslandInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IslandInfoService {
    private final IslandInfoRepository islandInfoRepository;
    
    public IslandInfoDTO findById(Integer islandId) {
        Optional<IslandInfoEntity> islandInfoEntity = islandInfoRepository.findById(islandId);
        if(islandInfoEntity.isPresent()) {
            IslandInfoDTO islandInfoDTO = new IslandInfoDTO(islandInfoEntity.get().getId(), islandInfoEntity.get().getName());
            return islandInfoDTO;
        }
        else return null;
    }
}
