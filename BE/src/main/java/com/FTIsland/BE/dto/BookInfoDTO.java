package com.FTIsland.BE.dto;

import com.FTIsland.BE.entity.BookInfoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookInfoDTO {
    private Integer id;
    private String title;
    private String description;
    private String category;
    private String country;
    private Integer totalPage;
    private String image;

    public static BookInfoDTO toBookInfoDTO(BookInfoEntity bookInfoEntity){
        BookInfoDTO bookInfoDTO = new BookInfoDTO();
        bookInfoDTO.setId(bookInfoEntity.getId());
        bookInfoDTO.setTitle(bookInfoEntity.getTitle());
        bookInfoDTO.setDescription(bookInfoEntity.getDescription());
        bookInfoDTO.setCategory(bookInfoEntity.getCategory());
        bookInfoDTO.setCountry(bookInfoEntity.getCountry());
        bookInfoDTO.setTotalPage(bookInfoEntity.getTotalPage());
        bookInfoDTO.setImage(bookInfoEntity.getImage());
        return bookInfoDTO;
    }

    public BookInfoDTO(Integer id, String title, String description, String category, String country, Integer totalPage, String image){
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.country = country;
        this.totalPage = totalPage;
        this.image = image;
    }
}
