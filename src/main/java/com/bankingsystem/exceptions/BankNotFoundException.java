package com.bankingsystem.exceptions;

public class BankNotFoundException extends BusnessException {
    public BankNotFoundException(String accountId) {
        super(String.format("Bank account %s not found", accountId));
    }
}
