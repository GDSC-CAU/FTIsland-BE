package com.FTIsland.BE.repository;

import com.FTIsland.BE.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Integer> {
    List<QuizEntity> findByBookIdAndLevel(Integer bookId, Integer level);
}
