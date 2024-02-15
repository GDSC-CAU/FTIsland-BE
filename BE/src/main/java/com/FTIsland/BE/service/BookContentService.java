package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.entity.BookContentEntity;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.repository.BookContentRepository;
import com.FTIsland.BE.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookContentService {
    private final BookContentRepository bookContentRepository;
    private final BookInfoRepository bookInfoRepository;

    public void save() { // 동화 내용 저장 (임시로 만든 method)
        ArrayList<BookContentDTO> bookContentDTOS = new ArrayList<>();

        bookContentDTOS.add(new BookContentDTO(1, 1, "어느 숲 속 마을에 엄마돼지와 아기돼지 삼 형제가 살고 있었어요.","", "", "qwe"));
        bookContentDTOS.add(new BookContentDTO(1, 2, "어느 날 엄마돼지는 아기돼지 삼 형제를 불러 모았어요.","", "", "asd"));

        for (BookContentDTO bookContentDTO : bookContentDTOS) {
            BookContentEntity bookContentEntity = BookContentEntity.toBookContentEntity(bookContentDTO);
            //bookContentEntity.setBook(findByBookName);
            bookContentRepository.save(bookContentEntity);
        }
    }

    public List<BookContentDTO> findByBookId(Integer bookId) {
        List<BookContentEntity> byBookId = bookContentRepository.findByBookId(bookId);
        List<BookContentDTO> bookContentDTOS = new ArrayList<>();
        for(BookContentEntity ent : byBookId){
            bookContentDTOS.add(BookContentDTO.toBookContentDTO(ent));
            //번역 로직 추가
        }
        return bookContentDTOS;
    }
}
