package com.thdev.JBank.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.math.BigDecimal;

@MappedSuperclass
abstract class Account {
    String name;
    String email;
    String password;
    @Column(name = "phone")
    String phoneNumber;
    String address;
    final BigDecimal balance = BigDecimal.ZERO;
    @Column(name = "is_Active")
    final boolean isActive = true;

    public Account() {
    }
    public Account(String name, String email, String password, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

}
