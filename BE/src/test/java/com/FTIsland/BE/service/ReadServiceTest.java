package com.FTIsland.BE.service;

import com.FTIsland.BE.book.progress.dto.BookProgressRequest;
import com.FTIsland.BE.book.progress.dto.BookProgressResponse;
import com.FTIsland.BE.entity.ReadEntity;
import com.FTIsland.BE.repository.ReadRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ReadServiceTest {

    private ReadRepository readRepository = Mockito.mock(ReadRepository.class);
    private ReadService readService;

    @BeforeEach
    void setUp() {
        readService = new ReadService(readRepository);
    }

    @Test
    void getProgress() {
        Integer userId = 1 ;
        Integer bookId = 1;
        Integer islandId = 1;

        BookProgressRequest bookProgressRequest = new BookProgressRequest().builder().userId(userId).islandId(islandId).build();
        ReadEntity readEntity = new ReadEntity();

        readEntity.builder().userId(userId).bookId(bookId).offset_value(2).limitNum(2).build();

        Mockito.when(readRepository.findById(1)).thenReturn(Optional.of(readEntity));

        List<BookProgressResponse> bookProgressResponseList = readService.getProgress(bookProgressRequest);

        // 값 검증
        Assertions.assertEquals(bookProgressResponseList.size(), 2);
        Assertions.assertEquals(bookProgressResponseList.get(0).getUserId(), bookProgressRequest.getUserId());
        Assertions.assertEquals(bookProgressResponseList.get(0).getLastPage(), 4);

        Mockito.verify(readRepository).findById(bookId);
    }
}