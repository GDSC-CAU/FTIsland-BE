package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.dto.VocaDTO;
import com.FTIsland.BE.dto.VocaDescriptionDTO;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.entity.UserVocaEntity;
import com.FTIsland.BE.entity.VocaEntity;
import com.FTIsland.BE.repository.BookInfoRepository;
import com.FTIsland.BE.repository.UserRepository;
import com.FTIsland.BE.repository.UserVocaRepository;
import com.FTIsland.BE.repository.VocaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
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
    private final UserRepository userRepository;

    // 단어 추가
    @Transactional
    public UserVocaEntity save(Integer userId, Integer vocaId){
        Optional <UserVocaEntity> userVoca = userVocaRepository.findByUserIdAndVocaId(userId, vocaId);

        if(userVoca.isPresent()){
            return userVoca.get();

        } else{
            UserVocaEntity userVocaEntity = new UserVocaEntity();
            userVocaEntity.setUserId(userId);
            userVocaEntity.setVocaId(vocaId);
            userVocaRepository.save(userVocaEntity);
            return userVocaEntity;
        }

    }

    // 단어 삭제
    @Transactional
    public void deleteUserVoca(Integer userId, Integer vocaId){
        userVocaRepository.deleteByUserIdAndVocaId(userId, vocaId);
    }

    // 단어장 리스트
    public List<VocaDTO> getVocaList(Integer userId){
        // 해당 유저의 단어장 조회
        List<UserVocaEntity> userVocaEntities = userVocaRepository.findByUserId(userId);

        // 유저의 주언어 보조언어 조회
        Optional<User> byId = userRepository.findById(userId);
        String mainLan = "ko";
        String subLan = "ko";
        if(byId.isPresent()){
            mainLan = byId.get().getMainLanguage();
            subLan = byId.get().getSubLanguage();
        }
        
        // 반환 DTO List
        List<VocaDTO> vocaDTOS = new ArrayList<>();

        // 단어장의 vocaId로 vocaEntity를 조회하여 번역 후 반환 DTO List에 정보 넣기
        for(UserVocaEntity ent : userVocaEntities){
            // 단어장의 vocaId로 voca 조회
            Integer vocaId = ent.getVocaId();
            Optional<VocaEntity> vocaEntity = vocaRepository.findById(vocaId);

            // 번역
            String mainWord = vocaEntity.get().getWord();
            String subWord = vocaEntity.get().getWord();

            if (!mainLan.equals("ko")){ // 주 언어 한국어가 아니라면 번역
                mainWord = translationService.test(mainLan, mainWord);
            }
            if (!subLan.equals("ko")){ // 보조 언어가 한국어가 아니라면 번역
                subWord = translationService.test(subLan, subWord);
            }

            // List에 추가
            VocaDTO vocaDTO = new VocaDTO();
            vocaDTO.setUserId(userId);
            vocaDTO.setVocaId(vocaEntity.get().getId());
            vocaDTO.setWord(mainWord);
            vocaDTO.setSubWord(subWord);
            vocaDTO.setImage(vocaEntity.get().getImage());

            vocaDTOS.add(vocaDTO);

        }
        return vocaDTOS;

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
        if (!mainLan.equals("ko")){ // 주 언어 한국어가 아니라면 번역
            mainWord = translationService.test(mainLan, mainWord);
            mainDescription = translationService.test(mainLan, mainDescription);
            mainBook = translationService.test(mainLan, mainBook);
        }
        if (!subLan.equals("ko")){ // 보조 언어가 한국어가 아니라면 번역
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

    // 금도끼 은도끼, 그림자 괴물에 대한 단어 추가
    // voca table에 단어를 추가하는 것!
    public void saveVoca() {

        // 금도끼 은도끼, 그림자 괴물 의 단어 저장
        // 같은 단어가 여러 번 나올 경우, 가장 앞의 단어를 저장
        vocaRepository.save(new VocaEntity(1, 1, 0, "정직", "남을 속이지 않는 것", "https://storage.googleapis.com/ft-island-image/honest.webp"));
        vocaRepository.save(new VocaEntity(2, 1, 2, "산신령", "산을 지키는 사람", "https://storage.googleapis.com/ft-island-image/sansinryeong.webp"));
        vocaRepository.save(new VocaEntity(3,1, 10, "욕심쟁이", "다른 사람에게 줄 생각을 하지 않고 자기만 가지려고 하는 사람", "https://storage.googleapis.com/ft-island-image/yoksim.webp"));
        vocaRepository.save(new VocaEntity(4, 1, 10, "샘", "다른 사람이 가진 것을 욕심내는 것", "https://storage.googleapis.com/ft-island-image/sam.webp"));
        vocaRepository.save(new VocaEntity(5, 1, 13, "재빠르게", "더 빠르게", "https://storage.googleapis.com/ft-island-image/fast.webp"));
        vocaRepository.save(new VocaEntity(6, 2, 0, "그림자", "해를 보면 내 뒤에 생기는 것", "https://storage.googleapis.com/ft-island-image/shadowimg.webp"));
        vocaRepository.save(new VocaEntity(7, 2, 2, "살금 살금", "조심스럽고 발소리가 나지 않는", "https://storage.googleapis.com/ft-island-image/salgeum.webp"));
        vocaRepository.save(new VocaEntity(8, 2, 4, "줄행랑", "뒤도 안돌아보고 도망가기", "https://storage.googleapis.com/ft-island-image/julhang.webp"));
    }
}
