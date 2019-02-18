package com.xx.demo.provider.bean;

public enum ErrorCode {
    DIVISOR_NOT_BE_ZERO("10011101", "divisor can not be zero ."),
    INFO_NOT_FOUND("10011102", "info not be found .");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
