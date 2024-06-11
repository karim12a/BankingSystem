package com.bankingsystem.controllers;

import com.bankingsystem.dtos.CustomerDTO;
import com.bankingsystem.services.AccountBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final AccountBankService accountBankService;
        @GetMapping
        ResponseEntity<List<CustomerDTO>> customers(){
            return ResponseEntity.ok(accountBankService.listCustomers());
        }
        @GetMapping("/search")
        ResponseEntity<List<CustomerDTO>> searchCustomers(@RequestParam(name = "keyword",defaultValue = "") String keyword){
                return ResponseEntity.ok(accountBankService.searchCustomers(keyword));
            }
        @GetMapping("/{id}")
        ResponseEntity<CustomerDTO>  getCustomer(@PathVariable Long id ){
                return ResponseEntity.ok(accountBankService.getCustomer(id));
            }
        @PostMapping("/new")
        ResponseEntity<CustomerDTO>  saveCustomer(@RequestBody CustomerDTO customerDTO){
                return ResponseEntity.ok(accountBankService.saveCustomer(customerDTO));
            }
         @PutMapping("/update/{id}")
        ResponseEntity<CustomerDTO>  updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
                return ResponseEntity.ok(accountBankService.updateCustomer(customerDTO));
            }
        @DeleteMapping("/{id}")
        ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
                accountBankService.deleteCustomer(id);
                return ResponseEntity.noContent().build();
            }
}
