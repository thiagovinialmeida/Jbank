package com.thdev.JBank.Domain;

import com.thdev.JBank.Domain.Enum.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
public class User extends Account{
    @Id
    String cpf;
    String civilStatus;
    String profession;
    LocalDate dateOfBirth;
    char gender;
    final Enum<AccountType> accType = AccountType.CLIENT;
}
