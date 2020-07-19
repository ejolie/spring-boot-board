package com.ejolie.board.common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
public class BaseResponse {

    private int status;

    private String message;

    @JsonFormat(timezone = "Asia/Seoul", shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss.SSSZ")
    private Timestamp timestamp;

    public BaseResponse() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public BaseResponse(StatusCode statusCode) {
        this();
        this.status = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public static BaseResponse success() {
        return BaseResponse.builder()
                .status(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}