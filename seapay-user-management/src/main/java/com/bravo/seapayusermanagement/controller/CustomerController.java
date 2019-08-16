package com.bravo.seapayusermanagement.controller;

import com.bravo.seapayusermanagement.domain.Customer;
import com.bravo.seapayusermanagement.exception.ResourceNotFoundException;
import com.bravo.seapayusermanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(value = "/customers")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping(value = "/customers")
    public Page<Customer> all(Pageable pageable){
        return customerRepository.findAll(pageable);
    }

    @GetMapping(value = "/customers/{customerId}")
    public Customer findByCustomerId (@PathVariable Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));
    }

    @PutMapping(value = "/customers/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerId, @RequestBody Customer newCustomer) {
        return customerRepository.findById(customerId).map(customer -> {
            customer.setName(newCustomer.getName());
            customer.setUsername(newCustomer.getUsername());
            customer.setEmail(newCustomer.getEmail());
            customer.setPassword(newCustomer.getPassword());
            customer.setPhoneNumber(newCustomer.getPhoneNumber());
            customerRepository.save(customer);
            return ResponseEntity.ok(customer);
        }).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));
    }
}
