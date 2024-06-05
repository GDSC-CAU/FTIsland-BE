package com.FTIsland.BE.book.content.dto;

import com.FTIsland.BE.book.content.entity.BookContentEntity;
import com.FTIsland.BE.dto.ContentVocaDTO;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
public class BookContentResponse {
    private Integer bookId; //bookName도 추가?
    private Integer page;
    private String mainLan;
    private String subLan;
    private String korContents;
    private String mainContents;
    private String subContents;
    private List<ContentVocaDTO> vocaList;
    private String image;

    @Builder
    public BookContentResponse(Integer bookId, Integer page, String mainLan, String subLan, String korContents, String mainContents, String subContents, List<ContentVocaDTO> vocaList, String image){
        this.bookId = bookId;
        this.page = page;
        this.mainLan = mainLan;
        this.subLan = subLan;
        this.korContents = korContents;
        this.mainContents = mainContents;
        this.subContents = subContents;
        this.vocaList = vocaList;
        this.image = image;
    }

    public BookContentEntity toBookContentEntity(){
        return BookContentEntity.builder()
                .bookId(bookId)
                .page(page)
                .korContents(korContents)
                .image(image)
                .build();
    }

}



