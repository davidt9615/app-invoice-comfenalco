package com.comfenalco.app_invoice.utils.exceptions;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(String message){
        super(message);
    }
}
