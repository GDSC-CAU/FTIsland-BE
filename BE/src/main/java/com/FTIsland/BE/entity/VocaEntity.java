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
    private String word;

    @Column
    private String description;

    @Column
    private String image;
}
