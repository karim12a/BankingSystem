package com.bankingsystem.services;

import com.bankingsystem.dtos.*;

import java.util.List;


public interface AccountBankService {

            CustomerDTO saveCustomer(CustomerDTO customerDTO);

            SavingAccountDTO saveCurrentBankAccount(SavingAccountDTO savingAccountDTO);

            SavingAccountDTO saveSavingBankAccount(SavingAccountDTO savingAccountDTO);

           List<CustomerDTO> listCustomers();

            BankAccountDTO getBankAccount(String accountId);

            void debit(String accountId, Long amount, String description);

            void credit(String accountId, Long amount, String description);

            void transfer();

            List<BankAccountDTO> bankAccountList();

            CustomerDTO getCustomer(Long customerId);

           CustomerDTO updateCustomer(CustomerDTO customerDTO);

            void deleteCustomer(Long customerId);

           List<AccountOperationDTO> accountHistory(String accountId);

            AccountHistoryDTO getAccountHistory(String accountId, int page, int size);

           List<CustomerDTO> searchCustomers(String keyWord);
}
