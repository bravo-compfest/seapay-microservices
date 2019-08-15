package com.bravo.seapaypayment.model;

import com.bravo.seapaypayment.exception.NegativeBalanceException;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "wallets")
@Entity
public class Wallet implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer user_id;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    public void addBalance(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }

    public void reduceBalance(BigDecimal balance) throws NegativeBalanceException {
        if (this.balance.compareTo(balance) < 0){
            throw new NegativeBalanceException("Cannot reduce balance, not enough balance");
        }
        this.balance = this.balance.subtract(balance);
    }

    public Wallet(int user_id, BigDecimal balance) {
        this.user_id = user_id;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("id: %d \n balance: %s", id, balance.toString());
    }
}
