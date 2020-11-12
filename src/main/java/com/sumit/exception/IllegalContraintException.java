package com.sumit.exception;

/**
 * Created by sumit on 29/10/20.
 */
public class IllegalContraintException extends ConstraintException {
    public IllegalContraintException(String message) {
        super(message);
    }

    public IllegalContraintException(String message, Throwable cause) {
        super(message, cause);
    }
}
