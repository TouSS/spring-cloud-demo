package com.xx.demo.provider.controller;

import com.xx.demo.provider.exception.CallingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xx.demo.provider.bean.Error;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = CallingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error callingErrorHandler(CallingException e) {
        return new Error(e.getCode(), e.getMessage());
    }
}
