package com.FTIsland.BE.bookContent.service;

import com.FTIsland.BE.bookContent.dto.BookContentRequest;
import com.FTIsland.BE.bookContent.dto.BookContentResponse;
import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.dto.ContentVocaDTO;
import com.FTIsland.BE.bookContent.entity.BookContentEntity;
import com.FTIsland.BE.entity.VocaEntity;
import com.FTIsland.BE.bookContent.repository.BookContentRepository;
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

    public void save() { // 동화 내용 저장 (임시로 만든 method) -> TODO: seed data 저장하는 구문 작성 후 메서드 삭제 예정 (toEntity 관련 에러 해결)
        ArrayList<BookContentDTO> bookContentDTOS = new ArrayList<>();

        // 금도끼 은도끼 저장
        bookContentDTOS.add(new BookContentDTO(1, 0, "","","옛날 어느 마을에 정직하고 마음씨 착한 나무꾼이 살고 있었어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver0.webp"));
        bookContentDTOS.add(new BookContentDTO(1, 1, "","","어느 날 나무꾼이 나무를 베고 있었는데, 도끼가 연못에 빠지고 말았어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver1.webp"));
        bookContentDTOS.add(new BookContentDTO(1, 2, "","","그때였어요. 연못에서 갑자기 하얀 연기가 일더니 하얀 옷을 입은 산신령이 나타났어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver2.webp"));

        bookContentDTOS.add(new BookContentDTO(1, 3, "","","산신령은 도끼를 잃어버려 울고 있는 나무꾼에게 도끼를 찾아준다고 했어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver2.webp"));
        bookContentDTOS.add(new BookContentDTO(1, 4, "","","산신령은 금도끼를 보여주며 물었어요. \"이 도끼가 네 도끼냐\"","", "", "https://storage.googleapis.com/ft-island-image/goldsilver3.webp"));
        bookContentDTOS.add(new BookContentDTO(1, 5, "","","나무꾼은 산신령이 보여주는 금도끼, 은도끼 모두 자신의 것이 아니라고 했어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver3.webp"));

        bookContentDTOS.add(new BookContentDTO(1, 6, "","","산신령은 물었어요. \"이 낡은 쇠도끼가 네 도끼냐\"","", "", "https://storage.googleapis.com/ft-island-image/goldsilver4.webp"));
        bookContentDTOS.add(new BookContentDTO(1, 7, "","","나무꾼은 환하게 웃으며 자신의 도끼가 맞다고 했어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver4.webp"));
        bookContentDTOS.add(new BookContentDTO(1, 8, "","","산신령은 말했어요. \"하하하! 참으로 정직한 나무꾼이로구나. 내가 선물로 금도끼, 은도끼를 선물로 주겠다.\"","", "", "https://storage.googleapis.com/ft-island-image/goldsilver4.webp"));

        bookContentDTOS.add(new BookContentDTO(1, 9, "","","나무꾼은 금도끼와 은도끼를 팔아 마을 최고의 부자가 되었어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver5.webp"));
        bookContentDTOS.add(new BookContentDTO(1, 10, "","","이 소식을 들은 욕심쟁이 나무꾼은 샘이 났어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver5.webp"));

        bookContentDTOS.add(new BookContentDTO(1, 11, "","","욕심쟁이 나무꾼은 일부러 쇠도끼를 빠뜨렸어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver6.webp"));

        bookContentDTOS.add(new BookContentDTO(1, 12, "","","그때 산신령이 나타났고, 욕심쟁이 나무꾼은 재빠르게 도끼를 찾아달라고 부탁했어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver7.webp"));
        bookContentDTOS.add(new BookContentDTO(1, 13, "","","산신령은 금도끼를 보여주며 물었어요. \"이 도끼가 네 도끼냐.\" 욕심쟁이 나무꾼은 맞다고 했어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver8.webp"));
        bookContentDTOS.add(new BookContentDTO(1, 14, "","","산신령은 은도끼를 보여주며 물었어요. \"이 도끼가 네 도끼냐.\" 욕심쟁이 나무꾼은 이번에도 맞다고 했어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver9.webp"));

        bookContentDTOS.add(new BookContentDTO(1, 15, "","","욕심쟁이 나무꾼은 금도끼, 은도끼, 쇠도끼 모두 가질 생각에 신이 났어요.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver10.webp"));
        bookContentDTOS.add(new BookContentDTO(1, 16, "","","그때 산신령이 크게 화를 내며 말했어요. \"네 이놈! 거짓말 치는 욕심쟁이에겐 쇠도끼도 어림없다!\"","", "", "https://storage.googleapis.com/ft-island-image/goldsilver11.webp"));

        bookContentDTOS.add(new BookContentDTO(1, 17, "","","욕심쟁이 나무꾼은 잘못된 욕심 때문에 크게 혼이 나고 쇠도끼도 잃어버렸답니다.","", "", "https://storage.googleapis.com/ft-island-image/goldsilver11.webp"));

        // 그림자 괴물 저장
        bookContentDTOS.add(new BookContentDTO(2, 0, "","","마을 근처 숲에는 무시무시한 그림자 괴물이 살고 있었어요.","", "", "https://storage.googleapis.com/ft-island-image/shadow0.webp"));
        bookContentDTOS.add(new BookContentDTO(2, 1, "","","어느 날 마을에 살고 있던 작은 아이 치치는 그림자 괴물이 궁금했어요.","", "", "https://storage.googleapis.com/ft-island-image/shadow1.webp"));
        bookContentDTOS.add(new BookContentDTO(2, 2, "","","살금 살금 그림자를 따라가보니... 늑대가 그림자로 장난을 치고 있었어요!","", "", "https://storage.googleapis.com/ft-island-image/shadow1.webp"));

        bookContentDTOS.add(new BookContentDTO(2, 3, "","","친화력이 좋은 치치는 늑대와 바로 친해졌고, 함께 그림자 놀이를 하며 놀았어요.","", "", "https://storage.googleapis.com/ft-island-image/shadow2.webp"));
        bookContentDTOS.add(new BookContentDTO(2, 4, "","","여우를 사냥하려고 숲 주변에 있던 사냥꾼이, 치치와 늑대의 그림자를 보고 줄행랑 쳤답니다!","", "", "https://storage.googleapis.com/ft-island-image/shadow3.webp"));

        for (BookContentDTO bookContentDTO : bookContentDTOS) {
            BookContentEntity bookContentEntity = BookContentEntity.toBookContentEntity(bookContentDTO); // TODO: seed data 저장 코드 작성 후 없애기
            bookContentRepository.save(bookContentEntity);
        }
    }

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
                    .image(ent.getImage())
                    .build();

            bookContentResponse.setVocaList(contentVocaDTOS);
            bookContentResponses.add(bookContentResponse);
        }

        // page 순으로 정렬
        bookContentResponses = bookContentResponses.stream().sorted(Comparator.comparing(BookContentResponse::getPage)).collect(Collectors.toList());

        return bookContentResponses;
    }
}
