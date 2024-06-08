package com.FTIsland.BE.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseData<T> {
    private int status_code;
    private String response_message;
    private T data;

    public ResponseData(final int status_code, final String response_message) {
        this.status_code = status_code;
        this.response_message = response_message;
        this.data = null;
    }

    public static<T> ResponseData<T> res(final int status_code, final String response_message) {
        return res(status_code, response_message, null);
    }

    public static<T> ResponseData<T> res(final int status_code, final String response_message, final T t) {
        return ResponseData.<T>builder()
                .data(t)
                .status_code(status_code)
                .response_message(response_message)
                .build();
    }
}
