package com.FTIsland.BE.repository;

import com.FTIsland.BE.entity.ReadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReadRepository extends JpaRepository<ReadEntity, Integer> {

    @Query("SELECT r FROM ReadEntity r WHERE r.userId = :userId AND r.bookId = :bookId")
    Optional<ReadEntity> findByUserIdAndBookId(Integer userId, Integer bookId);
    List<ReadEntity> findByUserId(Integer userId);
    List<ReadEntity> findAllByUserIdOrderByUpdatedAtDesc(Integer userId);

    Optional<ReadEntity> findByBookId(int nowId);
}
