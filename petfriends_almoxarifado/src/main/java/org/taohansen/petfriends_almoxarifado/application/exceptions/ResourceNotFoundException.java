package org.taohansen.petfriends_almoxarifado.application.exceptions;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}