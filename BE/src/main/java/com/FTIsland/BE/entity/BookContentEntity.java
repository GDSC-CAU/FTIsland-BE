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
    private String book;

    @Column
    private Integer page;

    @Column
    private String contents;

    @Column
    private String image;

    public static BookContentEntity toBookContentEntity(BookContentDTO bookContentDTO) {
        BookContentEntity bookContentEntity = new BookContentEntity();
        bookContentEntity.setBook(bookContentDTO.getBook());
        bookContentEntity.setPage(bookContentDTO.getPage());
        bookContentEntity.setContents(bookContentDTO.getMainContents()); //나중에 수정
        bookContentEntity.setImage(bookContentDTO.getImage());

        return bookContentEntity;

    }
}
