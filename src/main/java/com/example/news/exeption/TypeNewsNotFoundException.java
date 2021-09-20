package com.example.news.exeption;

public class TypeNewsNotFoundException extends RuntimeException {
    public TypeNewsNotFoundException(String message) {
        super(message);
    }
}
