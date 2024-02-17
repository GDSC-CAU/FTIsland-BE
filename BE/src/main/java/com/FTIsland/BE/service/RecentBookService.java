package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.RecentBookDTO;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.entity.ReadEntity;
import com.FTIsland.BE.repository.BookInfoRepository;
import com.FTIsland.BE.repository.ReadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecentBookService {
    private final ReadRepository readRepository;
    private final BookInfoRepository bookInfoRepository;
    public List<RecentBookDTO> findByUserId(RecentBookDTO requestDTO){
        var byUserId = readRepository.findByUserId(requestDTO.getUserId());

        System.out.println(requestDTO.getUserId());

        if(byUserId == null || byUserId.isEmpty()){
            //없을 경우 그대로 리턴? or 다른 방식으로 처리?
            //System.out.println(byUserId.get(0));
        } else {
            // 있을 경우 그대로 리턴
        }

        List<RecentBookDTO> responseDTOs = new ArrayList<>();
        for (ReadEntity ent : byUserId){
            RecentBookDTO recentBookDTO = new RecentBookDTO();
            recentBookDTO.setUserId(ent.getUserId());
            recentBookDTO.setBookId(ent.getBookId());
            Optional<BookInfoEntity> bookInfoEntity = bookInfoRepository.findById(ent.getBookId());
            if(bookInfoEntity.isPresent()){
                recentBookDTO.setTitle(bookInfoEntity.get().getTitle());
                recentBookDTO.setDescription(bookInfoEntity.get().getDescription());
                recentBookDTO.setImage(bookInfoEntity.get().getImage());
            } else{
             //
            }
            responseDTOs.add(recentBookDTO);
        }
        return responseDTOs;
    }
}
