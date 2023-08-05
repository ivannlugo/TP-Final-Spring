package com.GameDev.TaskManager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason =  "value not found")
public class NotFoundExceptions extends Exception{
    public NotFoundExceptions() {
    }

    public NotFoundExceptions(String message) {
        super(message);
    }

    public NotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundExceptions(Throwable cause) {
        super(cause);
    }

    public NotFoundExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
