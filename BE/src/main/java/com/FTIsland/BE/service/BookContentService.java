package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.entity.BookContentEntity;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.repository.BookContentRepository;
import com.FTIsland.BE.repository.BookInfoRepository;
import com.google.cloud.translate.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookContentService {
    private final BookContentRepository bookContentRepository;
    private final TranslationService translationService;

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

    public List<BookContentDTO> findByBookId(BookContentDTO requestDTO) {
        Integer bookId = requestDTO.getBookId();

        List<BookContentEntity> byBookId = bookContentRepository.findByBookId(bookId);
        List<BookContentDTO> bookContentDTOS = new ArrayList<>();

        String selectedLanguage = "ko";

        for(BookContentEntity ent : byBookId){
            // 번역 로직

            // 1. 주, 보조 언어 텍스트 둘 다 한국어를 기본으로 설정
            String mainText = ent.getKorContents();
            String subText = ent.getKorContents();

            // 2. 요청한 언어에 맞게 번역
            if (requestDTO.getMainLan().equals("ko")){ // 주 언어가 한국어가 아니라면 번역해서 저장
                selectedLanguage = requestDTO.getSubLan();
                subText = translationService.test(selectedLanguage, subText);
            }
            if (requestDTO.getSubLan().equals("ko")){ // 보조 언어가 한국어가 아니라면 번역해서 저장
                selectedLanguage = requestDTO.getMainLan();
                mainText = translationService.test(selectedLanguage, mainText);
            }

            // DTO List에 추가
            bookContentDTOS.add(new BookContentDTO(
                    ent.getBookId(),
                    ent.getPage(),
                    ent.getKorContents(),
                    mainText,
                    subText,
                    ent.getImage()
                    )
            );

        }
        return bookContentDTOS;
    }
}
