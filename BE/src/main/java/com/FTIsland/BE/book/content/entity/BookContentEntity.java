package com.FTIsland.BE.book.content.entity;

import com.FTIsland.BE.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "bookcontent")
@NoArgsConstructor
public class BookContentEntity extends BaseEntity {
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

    @Builder
    public BookContentEntity(Integer bookId, Integer page, String korContents, String image){
        this.bookId = bookId;
        this.page = page;
        this.korContents = korContents;
        this.image = image;
    }
}
