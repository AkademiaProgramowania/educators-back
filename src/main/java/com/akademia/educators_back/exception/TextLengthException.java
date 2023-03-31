package com.akademia.educators_back.exception;

public class TextLengthException extends RuntimeException{

    //TODO RESOLVED bardziej bym to nazwał TextLenghtException, i ewentualnie w komunikacie dać szczegóły
    public TextLengthException(String message) {
        super (message);
    }
}
