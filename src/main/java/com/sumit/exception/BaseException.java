package com.sumit.exception;

/**
 * Created by sumit on 29/10/20.
 */
public class BaseException extends Exception {
    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
