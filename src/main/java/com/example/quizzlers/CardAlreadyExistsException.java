package com.example.quizzlers;

public class CardAlreadyExistsException extends Exception {
    public CardAlreadyExistsException() {
        super();
    }

    public CardAlreadyExistsException(String message) {
        super(message);
    }
}
