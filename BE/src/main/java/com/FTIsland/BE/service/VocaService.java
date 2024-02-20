package com.FTIsland.BE.service;

import com.FTIsland.BE.entity.UserVocaEntity;
import com.FTIsland.BE.repository.UserVocaRepository;
import com.FTIsland.BE.repository.VocaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class VocaService {
    private final VocaRepository vocaRepository;
    private final UserVocaRepository userVocaRepository;

    // 단어 추가
    public UserVocaEntity save(Integer userId, Integer vocaId){
        UserVocaEntity userVocaEntity = new UserVocaEntity();
        userVocaEntity.setUserId(userId);
        userVocaEntity.setVocaId(vocaId);

        userVocaRepository.save(userVocaEntity);

        return userVocaEntity;
    }

    // 단어 삭제
    @Transactional
    public void deleteUserVoca(Integer userId, Integer vocaId){
        userVocaRepository.deleteByUserIdAndVocaId(userId, vocaId);
    }

}
