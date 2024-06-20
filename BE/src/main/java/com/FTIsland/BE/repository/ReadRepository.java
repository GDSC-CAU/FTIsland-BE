package com.FTIsland.BE.repository;

import com.FTIsland.BE.entity.ReadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReadRepository extends JpaRepository<ReadEntity, Integer> {

    @Query("SELECT re FROM ReadEntity re WHERE re.userId = :userId AND re.bookId IN (SELECT be.id FROM BookInfoEntity be WHERE be.islandInfoEntity.id = :islandId)")
    List<ReadEntity> findByUserIdAndIslandInfoEntityIslandId(Integer userId, Integer islandId);

    @Query("SELECT r FROM ReadEntity r WHERE r.userId = :userId AND r.bookId = :bookId")
    Optional<ReadEntity> findByUserIdAndBookId(Integer userId, Integer bookId);

    Optional<ReadEntity> findByBookId(int nowId);
}
