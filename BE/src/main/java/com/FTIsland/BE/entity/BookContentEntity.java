package com.FTIsland.BE.entity;

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

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookInfoEntity book;

    @Column
    private Integer page;

    @Column
    private String contents;

    @Column
    private String image;
}
