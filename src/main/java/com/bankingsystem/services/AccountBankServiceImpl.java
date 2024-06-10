package com.bankingsystem.services;

import com.bankingsystem.dtos.*;
import com.bankingsystem.entities.*;
import com.bankingsystem.exceptions.BankNotFoundException;
import com.bankingsystem.exceptions.CustomerNotFoundException;
import com.bankingsystem.mappers.Mappers;
import com.bankingsystem.nums.OperationType;
import com.bankingsystem.repositories.AccountOperationRepository;
import com.bankingsystem.repositories.BankAccountRepository;
import com.bankingsystem.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountBankServiceImpl implements AccountBankService {
    private final CustomerRepository customerRepository;
    private final BankAccountRepository bankAccountRepository;
    private final AccountOperationRepository accountOperationRepository;
    private final Mappers mappers;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(mappers.customerToEntity(customerDTO));
        return mappers.customerToDto(customer);
    }

    @Override
    public SavingAccountDTO saveSavingBankAccount(SavingAccountDTO savingAccountDTO) {
        Long customerId = savingAccountDTO.getCustomerDto().getId();
        customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId)) ;
        SavingAccount savingAccount = bankAccountRepository.save(mappers.savingAccountToEntity(savingAccountDTO));
        return mappers.savingAccountToDTO(savingAccount);
    }

    @Override
    public CurrentAccountDTO saveCurrentBankAccount(CurrentAccountDTO currentAccountDTO) {
        Long customerId = currentAccountDTO.getCustomerDto().getId();
        customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
        CurrentAccount currentAccount = bankAccountRepository.save(mappers.currentAccountToEntity(currentAccountDTO));
        return mappers.currentAccountToDTO(currentAccount);
    }

    @Override
    public List<CustomerDTO> listCustomers() {
       List<Customer> customerList =  customerRepository.findAll();
       return mappers.customerToDtoList(customerList);

    }

    @Override
    public BankAccountDTO getBankAccount(String accountId) {

        return null;
    }

    @Override
    public void debit(String accountId, double amount, String description) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElseThrow(() -> new BankNotFoundException(accountId));
        if(amount> bankAccount.getBalance()){
            throw new BankNotFoundException(accountId);
        }
        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setBankAccount(bankAccount);
        accountOperation.setDateOperation(new Date());
        accountOperation.setType(OperationType.DEBIT);
        accountOperation.setAmount(amount);
        accountOperation.setDescription(description);
        accountOperationRepository.save(accountOperation);
        double newBalance = bankAccount.getBalance()-amount;
        bankAccount.setBalance(newBalance);
        bankAccountRepository.save(bankAccount);

    }

    @Override
    public void credit(String accountId, double amount, String description) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElseThrow(() -> new BankNotFoundException(accountId));
        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setBankAccount(bankAccount);
        accountOperation.setDateOperation(new Date());
        accountOperation.setType(OperationType.CREDIT);
        accountOperation.setAmount(amount);
        accountOperation.setDescription("operation debit");
        accountOperationRepository.save(accountOperation);
        double newBalance = bankAccount.getBalance()+amount;
        bankAccount.setBalance(newBalance);
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount, String description) {
        debit( accountIdSource,  amount,  description);
        credit( accountIdDestination,  amount,  description);
    }

    @Override
    public List<BankAccountDTO> bankAccountList() {
        return null;
    }

    @Override
    public CustomerDTO getCustomer(Long customerId) {
       Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
        return mappers.customerToDto(customer);

    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {

       Customer customer =  customerRepository.save(mappers.customerToEntity(customerDTO));
        return mappers.customerToDto(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<AccountOperationDTO> accountHistory(String accountId) {
      List<AccountOperation> accountOperationList=  accountOperationRepository.findByBankAccountId(accountId);
       return mappers.accountOperationToDTOList(accountOperationList);
    }

    @Override
    public AccountHistoryDTO getAccountHistory(String accountId, int page, int size) {
        return null;
    }

    @Override
    public List<CustomerDTO> searchCustomers(String keyWord) {
        List<Customer> customerList =  customerRepository.searchCustomer(keyWord);
        return mappers.customerToDtoList(customerList);
    }
}
