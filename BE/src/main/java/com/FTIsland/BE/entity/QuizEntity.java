package com.FTIsland.BE.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "quiz")
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer bookId;

    @Column
    private Integer level;

    @Column
    private String quiz1;

    @Column
    private String quiz2;

    @Column
    private String quiz3;
}
