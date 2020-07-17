package org.springframework.boot.resttemplate.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
