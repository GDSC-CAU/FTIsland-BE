package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.IslandInfoDTO;
import com.FTIsland.BE.entity.IslandInfoEntity;
import com.FTIsland.BE.repository.IslandInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IslandInfoService {

    private final IslandInfoRepository islandInfoRepository;

    @Transactional
    public IslandInfoDTO findById(Integer islandId) {
        Optional<IslandInfoEntity> islandInfoEntity = islandInfoRepository.findById(islandId);
        IslandInfoDTO islandInfoDTO = new IslandInfoDTO().builder().id(islandInfoEntity.get().getId()).name(islandInfoEntity.get().getName()).build();
        return islandInfoDTO;
    }
}
