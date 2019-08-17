package com.bravo.seapaypayment.controller;

import com.bravo.seapaypayment.model.Transaction;
import com.bravo.seapaypayment.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping(value = "/transaction")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Transaction save(@RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }

//    @GetMapping(value = "/transaction/{userId}")
//    public Page<Transaction> findByUserId (@PathVariable Integer userId) {
//        return transactionRepository.findByUserId(userId);
//    }

    @GetMapping(value = "/transactions")
    public Page<Transaction> all(Pageable pageable){
        return transactionRepository.findAll(pageable);
    }
}

