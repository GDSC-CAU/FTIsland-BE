package com.FTIsland.BE.bookContent.dto;

import com.FTIsland.BE.dto.ContentVocaDTO;
import com.FTIsland.BE.entity.BookContentEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
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
    public BookContentResponse(Integer bookId, Integer page, String mainLan, String subLan, String korContents, String mainContents, String subContents, String image){
        this.bookId = bookId;
        this.page = page;
        this.mainLan = mainLan;
        this.subLan = subLan;
        this.korContents = korContents;
        this.mainContents = mainContents;
        this.subContents = subContents;
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



