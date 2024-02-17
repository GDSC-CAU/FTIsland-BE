package com.FTIsland.BE.entity;

import com.FTIsland.BE.dto.ReadDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "read")
public class ReadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Integer bookId;

    @Column
    private Integer offset;

    @Column
    private Integer limit;

    @CreationTimestamp
    @Column
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt;

    public static ReadEntity toReadEntity(ReadDTO readDTO){
        ReadEntity readEntity = new ReadEntity();
        readEntity.setUserId(readDTO.getUserId());
        readEntity.setBookId(readDTO.getBookId());
        readEntity.setOffset(readDTO.getOffset());
        readEntity.setLimit(readDTO.getLimit());
        //readEntity.setCreatedAt(readDTO.getCreatedAt());
        //readEntity.setUpdatedAt(readDTO.getUpdatedAt());

        return readEntity;
    }
}
