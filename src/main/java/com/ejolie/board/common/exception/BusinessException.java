package com.ejolie.board.common.exception;

import com.ejolie.board.common.response.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    private int status;

    private String message;

    public BusinessException(StatusCode statusCode) {
        this.status = statusCode.getCode();
        this.message = statusCode.getMessage();
    }
}