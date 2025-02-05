package com.test.shorturl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.test.shorturl.dto.GetShortUrlResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GetShortUrlResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        // 取得第一條錯誤訊息
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        // 回傳錯誤格式
        return new GetShortUrlResponse("400", errors.get(0), "");
    }

}