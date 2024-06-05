package com.test.shorturl.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ExceptionHandaller extends Exception {
    private String errorCode;

    public ExceptionHandaller(String errorCode) {
        this.errorCode = errorCode;
    }
}
