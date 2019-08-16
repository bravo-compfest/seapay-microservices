package com.bravo.seapayusermanagement.repository;

import com.bravo.seapayusermanagement.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
