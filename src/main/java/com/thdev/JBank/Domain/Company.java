package com.thdev.JBank.Domain;

import com.thdev.JBank.Domain.Enum.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Company extends Account{
    @Id
    private String cnpj;
    private String companyName;
    private String contactPerson;
    final Enum<AccountType> accType = AccountType.COMPANY;

    public Company(String name, String email, String phoneNumber, String address, String cnpj,
                   String companyName, String contactPerson) {
        super(name, email, phoneNumber, address);
        this.cnpj = cnpj;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
    }
}
