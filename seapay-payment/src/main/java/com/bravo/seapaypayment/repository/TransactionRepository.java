package com.bravo.seapaypayment.repository;

import com.bravo.seapaypayment.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
//    @Query("SELECT t FROM transaction JOIN wallet WHERE t.user_id = ?1")
//    Page<Transaction> findByUserId(Integer userId);
}
