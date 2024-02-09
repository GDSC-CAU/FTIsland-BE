package com.FTIsland.BE.entity;

import com.FTIsland.BE.dto.BookInfoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "book_info")
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

    // 나중에 islandId 추가

    public static BookInfoEntity toBookInfoEntity(BookInfoDTO bookInfoDTO){
        BookInfoEntity bookInfoEntity = new BookInfoEntity();
        bookInfoEntity.setId(bookInfoDTO.getId());
        bookInfoEntity.setTitle(bookInfoDTO.getTitle());
        bookInfoEntity.setDescription(bookInfoDTO.getDescription());
        bookInfoEntity.setCategory(bookInfoDTO.getCategory());
        bookInfoEntity.setCountry(bookInfoDTO.getCountry());
        bookInfoEntity.setTotalPage(bookInfoDTO.getTotalPage());
        bookInfoEntity.setImage(bookInfoDTO.getImage());
        return bookInfoEntity;
    }

}
