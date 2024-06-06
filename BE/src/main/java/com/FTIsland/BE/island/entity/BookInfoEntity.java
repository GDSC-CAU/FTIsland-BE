package com.FTIsland.BE.island.entity;

import com.FTIsland.BE.dto.BookInfoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "bookinfo")
@NoArgsConstructor
@ToString
public class BookInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String category;

    @Column
    private String country;

    @Column
    private Integer totalPage;

    @Column
    private String image;

    @Builder
    public BookInfoEntity (Integer id, String title, String description, String category, String country, Integer totalPage, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.country = country;
        this.totalPage = totalPage;
        this.image = image;
    }

//    public static BookInfoEntity toBookInfoEntity(BookInfoDTO bookInfoDTO){
//        BookInfoEntity bookInfoEntity = new BookInfoEntity();
//        bookInfoEntity.setId(bookInfoDTO.getId());
//        bookInfoEntity.setTitle(bookInfoDTO.getTitle());
//        bookInfoEntity.setDescription(bookInfoDTO.getDescription());
//        bookInfoEntity.setCategory(bookInfoDTO.getCategory());
//        bookInfoEntity.setCountry(bookInfoDTO.getCountry());
//        bookInfoEntity.setTotalPage(bookInfoDTO.getTotalPage());
//        bookInfoEntity.setImage(bookInfoDTO.getImage());
//        bookInfoEntity.setIslandId(bookInfoDTO.getIslandId());
//        return bookInfoEntity;
//    }

    @ManyToOne
    @JoinColumn(name = "islandId", referencedColumnName = "id")
    private IslandInfoEntity islandInfoEntity;

}
