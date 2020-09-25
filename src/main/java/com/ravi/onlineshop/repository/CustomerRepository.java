package com.ravi.onlineshop.repository;


import com.ravi.onlineshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository for Customer
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
