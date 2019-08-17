package com.bravo.seapayusermanagement.controller;

import com.bravo.seapayusermanagement.domain.Admin;
import com.bravo.seapayusermanagement.exception.ResourceNotFoundException;
import com.bravo.seapayusermanagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping(value = "/admins")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Admin save(@RequestBody Admin customer){
        return adminRepository.save(customer);
    }

    @GetMapping(value = "/admins")
    public Page<Admin> all(Pageable pageable){
        return adminRepository.findAll(pageable);
    }

    @GetMapping(value = "/admins/{adminId}")
    public Admin findByCustomerId (@PathVariable Integer adminId) {
        return adminRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin [adminId="+adminId+"] can't be found"));
    }

    @PutMapping(value = "/admins/{adminId}")
    public ResponseEntity<Admin> updateCustomer(@PathVariable Integer adminId, @RequestBody Admin newAdmin) {
        return adminRepository.findById(adminId).map(admin -> {
            admin.setName(newAdmin.getName());
            admin.setUsername(newAdmin.getUsername());
            admin.setPassword(newAdmin.getPassword());
            adminRepository.save(admin);
            return ResponseEntity.ok(admin);
        }).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+adminId+"] can't be found"));
    }
}
