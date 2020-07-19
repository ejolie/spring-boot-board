package com.ejolie.board.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class SingleResponse<T> extends BaseResponse {

    private T data;

    public SingleResponse(StatusCode statusCode, T data) {
        super(statusCode);
        this.data = data;
    }

    @Builder(builderMethodName = "SingleResponseBuilder")
    public SingleResponse(int status, String message, Timestamp timestamp, T data) {
        super(status, message, timestamp);
        this.data = data;
    }

    public static <T> SingleResponse<T> success(T data) {
        return (SingleResponse<T>) SingleResponseBuilder()
                .status(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data(data)
                .build();
    }
}
