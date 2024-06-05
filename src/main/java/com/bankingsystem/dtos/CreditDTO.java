package com.bankingsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditDTO {
    private String accountId;
    private String description;
    private double amount;
}
