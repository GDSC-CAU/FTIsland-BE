package com.FTIsland.BE.entity;

import com.FTIsland.BE.dto.BookContentDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "bookcontent")
public class BookContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@ManyToOne
    //@JoinColumn(name = "book_id")
    //private BookInfoEntity book;

    @Column
    private Integer bookId;

    @Column
    private Integer page;

    @Column
    private String korContents;

    @Column
    private String image;

    public static BookContentEntity toBookContentEntity(BookContentDTO bookContentDTO) {
        BookContentEntity bookContentEntity = new BookContentEntity();
        bookContentEntity.setBookId(bookContentDTO.getBookId());
        bookContentEntity.setPage(bookContentDTO.getPage());
        bookContentEntity.setKorContents(bookContentDTO.getKorContents()); //나중에 수정
        bookContentEntity.setImage(bookContentDTO.getImage());

        return bookContentEntity;

    }
}
