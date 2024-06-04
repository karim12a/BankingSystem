package com.bankingsystem.repositories;

import com.bankingsystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("Select c from Customer c where c.name = :paramName ")
    public List<Customer> searchCustomer(@Param("paramName") String name);
}
