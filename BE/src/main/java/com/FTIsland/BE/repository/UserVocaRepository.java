package com.FTIsland.BE.repository;

import com.FTIsland.BE.entity.UserVocaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserVocaRepository extends JpaRepository<UserVocaEntity, Integer> {
    List<UserVocaEntity> findByUserId(Integer userId);
    Optional<UserVocaEntity> findByUserIdAndVocaId(Integer userId, Integer vocaId);

    void deleteByUserIdAndVocaId(Integer userId, Integer vocaId);
}
