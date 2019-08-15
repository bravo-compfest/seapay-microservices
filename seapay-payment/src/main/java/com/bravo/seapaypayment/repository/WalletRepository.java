package com.bravo.seapaypayment.repository;

import com.bravo.seapaypayment.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
//    @Query("SELECT t FROM wallets WHERE t.user_id = ?1")
//    Wallet findByUser_id(Integer user_id);
}
