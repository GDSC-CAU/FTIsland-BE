package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookInfoService {
    private final BookInfoRepository bookInfoRepository;

    public void save(){ // 동화 정보 저장 (임시로 만든 method)
        ArrayList<BookInfoDTO> bookInfoDTOS = new ArrayList<>();

//        bookInfoDTOS.add(new BookInfoDTO(1,"아기 돼지 삼형제","아기 돼지 삼형제가 늑대로부터 현명하게 대처한 이야기", "모험", "영국", 12, "qwer", 1));
//        bookInfoDTOS.add(new BookInfoDTO(2,"콩쥐 팥쥐","콩쥐가 동물 친구들과 함께 팥쥐와 계모의 괴롭힘을 헤쳐나가는 이야기", "전래동화", "한국", 15, "asdf", 2));
//        bookInfoDTOS.add(new BookInfoDTO(3, "금도끼 은도끼", "도끼를 잃어버린 성실한 청년이 금도끼, 은도끼, 동도끼 모두를 가지고 선녀와 행복하게 사는 이야기", "전래동화", "한국", 10, "2342", 1));
        bookInfoDTOS.add(new BookInfoDTO(1, "금도끼 은도끼", "성실한 나무꾼은 과연 어떻게 금도끼를 갖게 되었을까요?", "교훈", "한국", 12, "https://storage.googleapis.com/ft-island-image/goldsilver0.webp", 1));
        bookInfoDTOS.add(new BookInfoDTO(2, "그림자 괴물", "그림자 괴물이 생겨난 이유가 궁금하지 않아?", "모험", "한국", 4, "https://storage.googleapis.com/ft-island-image/shadow0.webp", 1));
        bookInfoDTOS.add(new BookInfoDTO(3, "당나귀 알", "당나귀 알을 부화시키려는 어리석은 농부의 이야기", "교훈", "한국", 6, "https://storage.googleapis.com/ft-island-image/dangegg0.webp", 1));
        bookInfoDTOS.add(new BookInfoDTO(4, "별 왕자", "하늘 위의 별 왕자님이 땅 구경을 하러 내려갔어요! 과연 어떤 일이 벌어질까요?", "모험", "러시아", 4, "https://storage.googleapis.com/ft-island-image/starprince0.webp", 1));
        // 블로그에서 찾은 동화 넣기
        for(BookInfoDTO bookInfoDTO : bookInfoDTOS){
            BookInfoEntity bookInfoEntity = BookInfoEntity.toBookInfoEntity(bookInfoDTO);
            bookInfoRepository.save(bookInfoEntity);
        }
    }

    public BookInfoDTO findById(Integer id) {
        Optional<BookInfoEntity> byId = bookInfoRepository.findById(id);
        if(byId.isPresent()){
            BookInfoEntity bookInfoEntity = byId.get();
            BookInfoDTO bookInfoDTO = BookInfoDTO.toBookInfoDTO(bookInfoEntity);
            return bookInfoDTO;
        } else {
            return null;
        }
    }

    public String findNameById(Integer id) {
        Optional<BookInfoEntity> byId = bookInfoRepository.findById(id);
        if(byId.isPresent()){
            BookInfoEntity bookInfoEntity = byId.get();
            String bookTitle = bookInfoEntity.getTitle();
            return bookTitle;
        } else {
            return null;
        }
    }

    public List<Optional<BookInfoEntity>> findNameByIslandId(Integer islandId) {
        List<Optional<BookInfoEntity>> bookInfoEntityList = bookInfoRepository.findByIslandId(islandId);
        return bookInfoEntityList;

    }
}
