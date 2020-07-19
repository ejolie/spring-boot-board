package com.ejolie.board.common.response;

public enum StatusCode {

    SUCCESS(200, "Success"),
    ACCOUNT_NOT_FOUND(404, "User not found."),
    ACCOUNT_DUPLICATED(400, "User already exists.")
    ;

    private int code;
    private String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
