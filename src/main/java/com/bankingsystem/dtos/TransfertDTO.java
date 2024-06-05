package com.bankingsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransfertDTO {

    private BankAccountDTO bankAccountSource;
    private BankAccountDTO bankAccountDestination;
    private double amount;
    private String description;
}
