package com.thdev.JBank.Domain;

import com.thdev.JBank.Domain.Enum.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company extends Account{
    @Id
    private String cnpj;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_person")
    private String contactPerson;
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    AccountType accType;

    public Company() {}

    public Company(String name, String email, String password, String phoneNumber, String address, boolean isActive,
                   double balance, String cnpj, String companyName, String contactPerson) {
        super(name, email, password, phoneNumber, address);
        this.cnpj = cnpj;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.accType = AccountType.COMPANY;
    }
}
