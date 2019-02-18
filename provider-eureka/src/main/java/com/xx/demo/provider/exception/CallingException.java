package com.xx.demo.provider.exception;

import com.xx.demo.provider.bean.ErrorCode;

public class CallingException extends RuntimeException {
    private String code;
    private String message;

    public CallingException(ErrorCode error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public CallingException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
