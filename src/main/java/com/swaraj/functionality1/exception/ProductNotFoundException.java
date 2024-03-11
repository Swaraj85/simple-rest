package com.swaraj.functionality1.exception;

// unchecked exception
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
