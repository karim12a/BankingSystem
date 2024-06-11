package com.bankingsystem.services;

import com.bankingsystem.dtos.*;

import java.util.List;


public interface AccountBankService {

            CustomerDTO saveCustomer(CustomerDTO customerDTO);
            CurrentAccountDTO saveCurrentBankAccount(CurrentAccountDTO currentAccountDTO);
            SavingAccountDTO saveSavingBankAccount(SavingAccountDTO savingAccountDTO);
           List<CustomerDTO> listCustomers();
            BankAccountDTO getBankAccount(String accountId);
            void debit(String accountId, double amount, String description);
            void credit(String accountId, double amount, String description);
            void transfer(String accountIdSource, String accountIdDestination, double amount, String description);
            List<BankAccountDTO> bankAccountList();
            CustomerDTO getCustomer(Long customerId);
           CustomerDTO updateCustomer(CustomerDTO customerDTO);
            void deleteCustomer(Long customerId);
           List<AccountOperationDTO> accountHistory(String accountId);
            AccountHistoryDTO getAccountHistory(String accountId, int page, int size);
           List<CustomerDTO> searchCustomers(String keyWord);
}
