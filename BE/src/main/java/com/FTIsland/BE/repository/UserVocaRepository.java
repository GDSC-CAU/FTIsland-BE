package com.FTIsland.BE.repository;

import com.FTIsland.BE.entity.UserVocaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserVocaRepository extends JpaRepository<UserVocaEntity, Integer> {
    Optional<UserVocaEntity> findByUserId(Integer userId);

    void deleteByUserIdAndVocaId(Integer userId, Integer vocaId);
}
