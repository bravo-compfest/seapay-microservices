package com.bravo.seapayusermanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Table(name = "customers")
@Entity
public class Customer implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getLoyaltyLevel() {
        return loyaltyLevel;
    }

    public void setLoyaltyLevel(Integer loyaltyLevel) {
        this.loyaltyLevel = loyaltyLevel;
    }

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "loyalty_level")
    private Integer loyaltyLevel;

    public Customer() {

    }

    public Customer(String name, String username, String password, String email, String phoneNumber, Integer loyaltyLevel) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.loyaltyLevel = loyaltyLevel;
    }

    public void updateProfile(){

    }

    public void topUp(BigInteger amount){

    }

    public void transfer(BigInteger amount){

    }
}
