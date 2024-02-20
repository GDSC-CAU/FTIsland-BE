package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.dto.VocaDescriptionDTO;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.entity.UserVocaEntity;
import com.FTIsland.BE.entity.VocaEntity;
import com.FTIsland.BE.repository.BookInfoRepository;
import com.FTIsland.BE.repository.UserVocaRepository;
import com.FTIsland.BE.repository.VocaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VocaService {
    private final VocaRepository vocaRepository;
    private final UserVocaRepository userVocaRepository;
    private final BookInfoRepository bookInfoRepository;
    private final TranslationService translationService;

    // 단어 추가
    public UserVocaEntity save(Integer userId, Integer vocaId){
        UserVocaEntity userVocaEntity = new UserVocaEntity();
        userVocaEntity.setUserId(userId);
        userVocaEntity.setVocaId(vocaId);

        userVocaRepository.save(userVocaEntity);

        return userVocaEntity;
    }

    // 단어 삭제
    @Transactional
    public void deleteUserVoca(Integer userId, Integer vocaId){
        userVocaRepository.deleteByUserIdAndVocaId(userId, vocaId);
    }

    // 단어 설명 조회 및 번역
    public List<VocaDescriptionDTO> getVocaDescription(Integer vocaId, String mainLan, String subLan){
        // vocaId로 단어 조회 (단어, 설명, 책id)
        Optional<VocaEntity> byId = vocaRepository.findById(vocaId);
        String korWord = byId.get().getWord();
        String korDescription = byId.get().getDescription();

        // 책 id로 책 이름 조회
        Optional<BookInfoEntity> byBookId = bookInfoRepository.findById(byId.get().getBookId());
        String bookName = byBookId.get().getTitle();

        // 단어 및 단어 설명 번역
        // 1. 주, 보조 언어 텍스트 둘 다 한국어를 기본으로 설정
        String mainWord = korWord;
        String subWord = korWord;

        String mainDescription = korDescription;
        String subDescription = korDescription;

        String mainBook = bookName;
        String subBook = bookName;

        // 2. 요청한 언어에 맞게 번역
        if (!mainLan.equals("ko")){ // 주 언어 한국어가 아니라면 번역해서 저장
            mainWord = translationService.test(mainLan, mainWord);
            mainDescription = translationService.test(mainLan, mainDescription);
            mainBook = translationService.test(mainLan, mainBook);
        }
        if (!subLan.equals("ko")){ // 보조 언어가 한국어가 아니라면 번역해서 저장
            subWord = translationService.test(subLan, subWord);
            subDescription = translationService.test(subLan, subDescription);
            subBook = translationService.test(subLan, subBook);
        }

        List<VocaDescriptionDTO> vocaDescriptionDTOS = new ArrayList<>();
        vocaDescriptionDTOS.add(new VocaDescriptionDTO(
                mainWord,
                mainDescription,
                mainBook
        ));
        vocaDescriptionDTOS.add(new VocaDescriptionDTO(
                subWord,
                subDescription,
                subBook
        ));

        return vocaDescriptionDTOS;

    }
}
