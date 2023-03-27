package com.akademia.educators_back.exception;

public class TextIsToLongOrToShortException extends RuntimeException{
    public TextIsToLongOrToShortException(String message) {
        super (message);
    }
}
