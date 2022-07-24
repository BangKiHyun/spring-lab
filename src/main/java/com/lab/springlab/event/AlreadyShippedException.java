package com.lab.springlab.event;

public class AlreadyShippedException extends RuntimeException {

    public AlreadyShippedException(String message) {
        super(message);
    }
}
