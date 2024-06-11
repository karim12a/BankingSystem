package com.bankingsystem.mappers;

import com.bankingsystem.dtos.*;
import com.bankingsystem.entities.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@RequiredArgsConstructor
public class Mappers {
    private final ModelMapper modelMapper;
    public Customer customerToEntity(CustomerDTO customerDTO){
           return modelMapper.map(customerDTO, Customer.class);
    }
   public CustomerDTO customerToDto(Customer customer){
        return modelMapper.map(customer, CustomerDTO.class);
    }
    public List<CustomerDTO> customerToDto(List<Customer> customerList){
        return customerList.stream().map(this::customerToDto).toList();
    }
    public SavingAccount savingAccountToEntity(SavingAccountDTO savingAccountDTO){
        return modelMapper.map(savingAccountDTO, SavingAccount.class);
    }

    public SavingAccountDTO savingAccountToDTO(SavingAccount savingAccount){
        return modelMapper.map(savingAccount, SavingAccountDTO.class);
    }

    public CurrentAccount currentAccountToEntity(CurrentAccountDTO currentAccountDTO){
        return modelMapper.map(currentAccountDTO, CurrentAccount.class);
    }

    public CurrentAccountDTO currentAccountToDTO(CurrentAccount currentAccount){
        return modelMapper.map(currentAccount, CurrentAccountDTO.class);
    }

    public AccountOperationDTO accountOperationToDTO(AccountOperation accountOperation){
        return modelMapper.map(accountOperation, AccountOperationDTO.class);
    }
    public AccountOperation accountOperationToEntity(AccountOperationDTO accountOperationDTO){
        return modelMapper.map(accountOperationDTO, AccountOperation.class);
    }
    public List<AccountOperation> accountOperationToEntity (List<AccountOperationDTO> accountOperationDTOList){
        return accountOperationDTOList.stream().map(this::accountOperationToEntity).toList();
    }
    public List<AccountOperationDTO> accountOperationToDTO(List<AccountOperation> accountOperationList){
        return accountOperationList.stream().map(this::accountOperationToDTO).toList();
    }
}
