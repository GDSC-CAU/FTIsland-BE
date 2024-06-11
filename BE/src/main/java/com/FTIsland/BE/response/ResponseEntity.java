package com.FTIsland.BE.response;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseEntity {
    @Enumerated(EnumType.STRING)
    public Status status;

    public Object data;
}
