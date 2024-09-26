package com.taohansen.petfriends_cliente.application.exceptions;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}