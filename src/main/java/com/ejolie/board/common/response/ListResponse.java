package com.ejolie.board.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
public class ListResponse<T> extends BaseResponse {

    private List<T> data;

    public ListResponse(StatusCode statusCode, List<T> data) {
        super(statusCode);
        this.data = data;
    }

    @Builder(builderMethodName = "ListResponseBuilder")
    public ListResponse(int status, String message, Timestamp timestamp, List<T> data) {
        super(status, message, timestamp);
        this.data = data;
    }

    /**
     * TODO: 제네릭 이슈
     * @return
     */
    public static <T> ListResponse<T> success(List<T> data) {
        return (ListResponse<T>) ListResponseBuilder()
                .status(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data((List<Object>) data)
                .build();
    }
}
