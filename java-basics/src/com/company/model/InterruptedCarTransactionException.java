package com.company.model;

public class InterruptedCarTransactionException extends RuntimeException{

    public InterruptedCarTransactionException(String message) {
        super("The car transaction has been interrupted: "+message);
    }
}
