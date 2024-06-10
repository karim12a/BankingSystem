package com.bankingsystem.exceptions;

public class CustomerNotFoundException extends BusnessException{
    public CustomerNotFoundException(Long id) {
        super(String.format("customer id , %s not found ",id));
    }
}
