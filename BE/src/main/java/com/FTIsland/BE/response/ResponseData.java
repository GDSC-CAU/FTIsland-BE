package com.FTIsland.BE.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseData<T> {
    private int status_code;
    private String status_message;
}
