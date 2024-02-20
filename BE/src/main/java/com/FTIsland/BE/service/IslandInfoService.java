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

    public void save() { // 동화 정보 저장(임시로 만든 method)
        ArrayList<IslandInfoDTO> islandInfoDTOS = new ArrayList<>();
        islandInfoDTOS.add(new IslandInfoDTO(1, "지혜"));
        islandInfoDTOS.add(new IslandInfoDTO(2, "기쁨"));
        islandInfoDTOS.add(new IslandInfoDTO(3, "행복"));
        islandInfoDTOS.add(new IslandInfoDTO(4, "용기"));
        islandInfoDTOS.add(new IslandInfoDTO(5, "희망"));
        islandInfoDTOS.add(new IslandInfoDTO(6, "미지"));

        for(IslandInfoDTO islandInfoDTO : islandInfoDTOS) {
            IslandInfoEntity islandInfoEntity = IslandInfoEntity.toIslandInfoEntity(islandInfoDTO);
            islandInfoRepository.save(islandInfoEntity);
        }

    }

    public IslandInfoDTO findById(Integer islandId) {
        Optional<IslandInfoEntity> islandInfoEntity = islandInfoRepository.findById(islandId);
        if(islandInfoEntity.isPresent()) {
            IslandInfoDTO islandInfoDTO = new IslandInfoDTO(islandInfoEntity.get().getId(), islandInfoEntity.get().getName());
            return islandInfoDTO;
        }
        else return null;
    }
}
