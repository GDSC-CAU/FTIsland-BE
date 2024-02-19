package com.FTIsland.BE.repository;

import com.FTIsland.BE.entity.BookInfoEntity;
import com.google.api.services.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfoEntity, Integer> {
    Optional<BookInfoEntity> findById(Integer id);
    List<Optional<BookInfoEntity>> findByIslandId(Integer islandId);
}
