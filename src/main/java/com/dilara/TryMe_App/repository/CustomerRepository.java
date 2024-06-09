package com.dilara.TryMe_App.repository;

import com.dilara.TryMe_App.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Optional<Customer> findByEmailAndPassword(String email, String password);

    Optional<Customer> findAllByEmailContainingIgnoreCase(String email);
}
