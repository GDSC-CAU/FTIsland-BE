package com.FTIsland.BE.dto;

import com.FTIsland.BE.entity.BookContentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private String image;

    public BookContentDTO(Integer bookId, Integer page, String korContents, String mainContents, String subContents, String image){
        this.bookId = bookId;
        this.page = page;
        this.korContents = korContents;
        this.mainContents = mainContents; //나중에 수정
        this.subContents = subContents; //나중에 수정
        this.image = image;
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


