package com.bravo.seapaypayment.controller;

import com.bravo.seapaypayment.model.Wallet;
import com.bravo.seapaypayment.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class WalletController {
    @Autowired
    private WalletRepository walletRepository;

    @PostMapping(value = "/wallet")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Wallet save(@RequestBody Wallet wallet){
        return walletRepository.save(wallet);
    }

//    @GetMapping(value = "/wallet/{userId}")
//    public Wallet findByUserId (@PathVariable Integer userId) {
//        return walletRepository.findByUser_id(userId);
//    }

    @GetMapping(value = "/wallets")
    public Page<Wallet> all(Pageable pageable){
        return walletRepository.findAll(pageable);
    }
}

