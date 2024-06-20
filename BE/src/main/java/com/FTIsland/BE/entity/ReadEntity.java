package com.FTIsland.BE.entity;

import com.FTIsland.BE.base.BaseEntity;
import com.FTIsland.BE.dto.ReadDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
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


    public static ReadEntity toReadEntity(ReadDTO readDTO){
        ReadEntity readEntity = new ReadEntity();
        readEntity.setUserId(readDTO.getUserId());
        readEntity.setBookId(readDTO.getBookId());
        readEntity.setOffset_value(readDTO.getOffset_value());
        readEntity.setLimitNum(readDTO.getLimitNum());

        return readEntity;
    }
}
