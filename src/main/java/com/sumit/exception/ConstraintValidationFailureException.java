package com.sumit.exception;

/**
 * Created by sumit on 29/10/20.
 */
public class ConstraintValidationFailureException extends ConstraintException {
    public ConstraintValidationFailureException(String message) {
        super(message);
    }

    public ConstraintValidationFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
