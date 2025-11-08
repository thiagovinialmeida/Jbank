package com.thdev.JBank.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thdev.JBank.Domain.Enum.AccountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends Account{
    @Id
    String cpf;
    @Column(name = "civil_Status")
    String civilStatus;
    String profession;
    @Column(name = "date_of_birth")
    LocalDate dateOfBirth;
    char gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    AccountType accType;

    public User() {}

    public User(String name, String email, String password, String phoneNumber, String address, String cpf, String civilStatus,
                String profession, LocalDate dateOfBirth, char gender){
        super(name, email, password, phoneNumber, address);
        this.cpf = cpf;
        this.civilStatus = civilStatus;
        this.profession = profession;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.accType = AccountType.CLIENT;
    }
}
