package com.FTIsland.BE.island.entity;

import com.FTIsland.BE.dto.BookInfoDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Table(name = "bookinfo")
@NoArgsConstructor
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

    @Column
    private Integer islandId;

    @Builder
    public BookInfoEntity (Integer id, String title, String description, String category, String country, Integer totalPage, String image, Integer islandId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.country = country;
        this.totalPage = totalPage;
        this.image = image;
        this.islandId = islandId;
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

}
