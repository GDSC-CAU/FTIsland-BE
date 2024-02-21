package com.FTIsland.BE.repository;

import com.FTIsland.BE.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Integer> {
    Optional<QuizEntity> findByBookIdAndLevel(Integer bookId, Integer level);
}
