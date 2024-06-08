package com.FTIsland.BE.book.content.service;

import com.FTIsland.BE.book.content.entity.BookContentEntity;
import com.FTIsland.BE.book.content.dto.BookContentRequest;
import com.FTIsland.BE.book.content.dto.BookContentResponse;
import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.dto.ContentVocaDTO;
import com.FTIsland.BE.entity.VocaEntity;
import com.FTIsland.BE.book.content.repository.BookContentRepository;
import com.FTIsland.BE.repository.VocaRepository;
import com.FTIsland.BE.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookContentService {
    private final BookContentRepository bookContentRepository;
    private final TranslationService translationService;
    private final VocaRepository vocaRepository;

    public List<BookContentResponse> findByBookId(BookContentRequest requestDTO) {
        // bookId를 통한 BookContentEntity 조회
        Integer bookId = requestDTO.getBookId();
        List<BookContentEntity> byBookId = bookContentRepository.findByBookId(bookId);

        // return값 정의
        List<BookContentResponse> bookContentResponses = new ArrayList<>();

        // 번역 로직 - 한 페이지(한 줄)씩 번역이라서 for문 사용
        for(BookContentEntity ent : byBookId){

            // 1. 주, 보조 언어 텍스트(내용 한 줄) 둘 다 한국어를 기본으로 설정
            String mainText = ent.getKorContents();
            String subText = ent.getKorContents();

            // 2. 요청한 언어에 맞게 번역
            if (!requestDTO.getMainLan().equals("ko")){ // 주 언어 한국어가 아니라면 번역
                mainText = translationService.test(requestDTO.getMainLan(), mainText);
            }
            if (!requestDTO.getSubLan().equals("ko")){ // 보조 언어가 한국어가 아니라면 번역
                subText = translationService.test(requestDTO.getSubLan(), subText);
            }

            // 3. 해당 페이지의 vocaId, word, subWord 가져오기
            var vocaEntities = vocaRepository.findByBookIdAndPage(ent.getBookId(), ent.getPage());
            List<ContentVocaDTO> contentVocaDTOS = new ArrayList<>();

            for(VocaEntity entity : vocaEntities){
                ContentVocaDTO contentVocaDTO = new ContentVocaDTO();
                contentVocaDTO.setVocaId(entity.getId());

                String mainWord = entity.getWord();
                String subWord = entity.getWord();

                if (!requestDTO.getMainLan().equals("ko")){ // 주 언어 한국어가 아니라면 번역
                    mainWord = translationService.test(requestDTO.getMainLan(), mainWord);
                }
                if (!requestDTO.getSubLan().equals("ko")){ // 보조 언어가 한국어가 아니라면 번역
                    subWord = translationService.test(requestDTO.getSubLan(), subWord);
                }
                contentVocaDTO.setWord(mainWord);
                contentVocaDTO.setSubWord(subWord);
                contentVocaDTOS.add(contentVocaDTO);
            }

            // DTO List에 추가
            BookContentResponse bookContentResponse = new BookContentResponse().builder()
                    .bookId(ent.getBookId())
                    .page(ent.getPage())
                    .mainLan(requestDTO.getMainLan())
                    .subLan(requestDTO.getSubLan())
                    .korContents(ent.getKorContents())
                    .mainContents(mainText)
                    .subContents(subText)
                    .vocaList(contentVocaDTOS)
                    .image(ent.getImage())
                    .build();

            bookContentResponses.add(bookContentResponse);
        }

        // page 순으로 정렬
        bookContentResponses = bookContentResponses.stream().sorted(Comparator.comparing(BookContentResponse::getPage)).collect(Collectors.toList());

        return bookContentResponses;
    }
}
