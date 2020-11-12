package com.sumit.exception;

/**
 * Created by sumit on 29/10/20.
 */
public class DuplicateResourceException extends BaseException {

    public DuplicateResourceException(String message) {
        super(message);
    }

    public DuplicateResourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
