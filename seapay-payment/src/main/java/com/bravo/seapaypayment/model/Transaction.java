package com.bravo.seapaypayment.model;

import com.bravo.seapaypayment.exception.NegativeBalanceException;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "transactions")
@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Wallet receiver;

    @Column(name = "amount")
    private BigDecimal amount;

    public Transaction(Wallet sender, Wallet receiver, BigDecimal amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public void transfer(BigDecimal amount) {
        try {
            this.sender.addBalance(amount);
            this.receiver.reduceBalance(amount);
        } catch (NegativeBalanceException error) {
            System.out.println(error.toString());
        }
    }
}

