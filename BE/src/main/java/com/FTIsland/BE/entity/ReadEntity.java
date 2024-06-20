package com.FTIsland.BE.entity;

import com.FTIsland.BE.base.BaseEntity;
import com.FTIsland.BE.dto.ReadDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "readbook")
public class ReadEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer userId;

    @Column
    private Integer bookId;

    @Column
    private Integer offset_value;

    @Column
    private Integer limitNum;

    @Builder
    public ReadEntity(Integer userId, Integer bookId, Integer offset_value, Integer limitNum) {
        this.userId = userId;
        this.bookId = bookId;
        this.offset_value = offset_value;
        this.limitNum = limitNum;
    }

    public static ReadEntity toReadEntity(ReadDTO readDTO){
        ReadEntity readEntity = new ReadEntity();
        readEntity.setUserId(readDTO.getUserId());
        readEntity.setBookId(readDTO.getBookId());
        readEntity.setOffset_value(readDTO.getOffset_value());
        readEntity.setLimitNum(readDTO.getLimitNum());

        return readEntity;
    }
}
