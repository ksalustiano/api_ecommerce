package com.kermes.apiecommerce.Exeptions;

public class UniqueViolationException extends RuntimeException {

    public UniqueViolationException(String message){
        super(message);
    }
}
