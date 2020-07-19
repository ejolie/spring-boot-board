package com.ejolie.board.common.response;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service 안 쓰고 static class 쓰는 방식도 존재.
 */
@Service
public class ResponseService {

    public BaseResponse getResponse(StatusCode statusCode) {
        return new BaseResponse(statusCode);
    }

    public BaseResponse getSuccessResponse() {
        return getResponse(StatusCode.SUCCESS);
    }

    public <T> SingleResponse<T> getSingleResponse(T data, StatusCode statusCode) {
        return new SingleResponse(statusCode, data);
    }

    public <T> SingleResponse<T> getSingleSuccessResponse(T data) {
        return getSingleResponse(data, StatusCode.SUCCESS);
    }

    public <T> ListResponse<T> getListResponse(List<T> data, StatusCode statusCode) {
        return new ListResponse<>(statusCode, data);
    }

    public <T> ListResponse<T> getListSuccessResponse(List<T> data) {
        return getListResponse(data, StatusCode.SUCCESS);
    }
}
