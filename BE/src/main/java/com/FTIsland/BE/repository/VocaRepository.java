package com.FTIsland.BE.repository;

import com.FTIsland.BE.entity.VocaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VocaRepository extends JpaRepository<VocaEntity, Integer> {
    Optional<VocaEntity> findById(Integer id);

    List<VocaEntity> findByBookIdAndPage(Integer bookId, Integer page);
}
