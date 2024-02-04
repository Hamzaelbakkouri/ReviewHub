package com.app.ReviewHub.Exeptions;

public class DuplicateExeption extends RuntimeException {
    public DuplicateExeption(String message) {
        super(message);
    }
}
