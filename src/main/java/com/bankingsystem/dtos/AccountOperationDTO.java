package com.bankingsystem.dtos;

import com.bankingsystem.entities.BankAccount;
import com.bankingsystem.nums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountOperationDTO {

    private Long id;
    private Date dateOperation;
    private double amount;
    private OperationType type;
    private BankAccount bankAccount;
    private String description;
}
