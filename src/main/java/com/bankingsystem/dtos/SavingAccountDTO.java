package com.bankingsystem.dtos;

import com.bankingsystem.nums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavingAccountDTO {
    private String id;
    private double balance ;
    private Date createdAt;
    private AccountStatus accountStatus;
    private CustomerDTO customerDto;
    private double interestRate ;
}
