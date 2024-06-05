package com.FTIsland.BE.dto;

import com.FTIsland.BE.book.content.entity.BookContentEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookContentDTO {
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
    public BookContentDTO(Integer bookId, Integer page, String mainLan, String subLan, String korContents, String mainContents, String subContents, String image){
        this.bookId = bookId;
        this.page = page;
        this.mainLan = mainLan;
        this.subLan = subLan;
        this.korContents = korContents;
        this.mainContents = mainContents; //나중에 수정
        this.subContents = subContents; //나중에 수정
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

//    public static BookContentDTO toBookContentDTO(BookContentEntity bookContentEntity) {
//        BookContentDTO bookContentDTO = new BookContentDTO();
//        bookContentDTO.setBookId(bookContentEntity.getBookId());
//        bookContentDTO.setPage(bookContentEntity.getPage());
//        bookContentDTO.setKorContents(bookContentEntity.getKorContents());
//        bookContentDTO.setMainContents(bookContentEntity.getKorContents()); //나중에 수정
//        bookContentDTO.setSubContents(bookContentEntity.getKorContents()); //나중에 수정
//        bookContentDTO.setImage(bookContentEntity.getImage());
//
//        return bookContentDTO;
//    }
}


