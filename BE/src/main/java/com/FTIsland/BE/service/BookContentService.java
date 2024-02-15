package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.entity.BookContentEntity;
import com.FTIsland.BE.repository.BookContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BookContentService {
    private final BookContentRepository bookContentRepository;

    public void save() { // 동화 내용 저장 (임시로 만든 method)
        ArrayList<BookContentDTO> bookContentDTOS = new ArrayList<>();

        bookContentDTOS.add(new BookContentDTO("아기 돼지 삼형제", 1, "어느 숲 속 마을에 엄마돼지와 아기돼지 삼 형제가 살고 있었어요.", "", "qwe"));
        bookContentDTOS.add(new BookContentDTO("아기 돼지 삼형제", 2, "어느 날 엄마돼지는 아기돼지 삼 형제를 불러 모았어요.", "", "asd"));

        for (BookContentDTO bookContentDTO : bookContentDTOS) {
            BookContentEntity bookContentEntity = BookContentEntity.toBookContentEntity(bookContentDTO);
            bookContentRepository.save(bookContentEntity);
        }
    }
}
