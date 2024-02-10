package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.BindException;
import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookInfoService {
    private final BookInfoRepository bookInfoRepository;

    public void save(){ // 동화 정보 저장 (임시로 만든 method)
        ArrayList<BookInfoDTO> bookInfoDTOS = new ArrayList<>();

        bookInfoDTOS.add(new BookInfoDTO(1,"아기 돼지 삼형제","아기 돼지들이~~", "모험", "영국", 12, "qwer"));
        bookInfoDTOS.add(new BookInfoDTO(2,"콩쥐 팥쥐","옛날에 콩쥐가 ~~", "전래동화", "한국",15,"asdf"));

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
}
