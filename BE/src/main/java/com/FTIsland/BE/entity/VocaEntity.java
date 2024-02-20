package com.FTIsland.BE.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "voca")
public class VocaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer bookId;

    @Column
    private Integer page;

    @Column
    private String word;

    @Column
    private String description;

    @Column
    private String image;

    public VocaEntity() {
        // 기본 생성자 내용 추가 (필요한 경우)
    }

    public VocaEntity(Integer id, Integer bookId, Integer page, String word, String description, String image) {
        this.id = id;
        this.bookId = bookId;
        this.page = page;
        this.word = word;
        this.description = description;
        this.image = image;
    }
}
