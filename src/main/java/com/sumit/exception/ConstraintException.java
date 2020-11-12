package com.sumit.exception;

/**
 * Created by sumit on 29/10/20.
 */
public class ConstraintException extends BaseException {
    public ConstraintException(String message) {
        super(message);
    }

    public ConstraintException(String message, Throwable cause) {
        super(message, cause);
    }
}
