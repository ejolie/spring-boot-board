package com.ejolie.board.common.exception;

import com.ejolie.board.common.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse methodArgumenatNotValidException(MethodArgumentNotValidException ex) {
        return BaseResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getBindingResult().getFieldError().getDefaultMessage())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    }

    /**
     * TODO: 실제 코드 값이 200으로 가는지 확인해보기
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessException(BusinessException ex) {
        return BaseResponse.builder()
                .status(ex.getStatus())
                .message(ex.getMessage())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}
