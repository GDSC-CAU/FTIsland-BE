package com.FTIsland.BE.repository;

import com.FTIsland.BE.entity.ReadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReadRepository extends JpaRepository<ReadEntity, Long> {
    Optional<ReadEntity> findByUserIdAndBookId(Long userId, Integer bookId);
    List<ReadEntity> findByUserId(Long userId);
    // Optional<ReadEntity> findByUserId(Long userId);
}
