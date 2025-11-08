package com.thdev.JBank.Infrastructure;

import com.thdev.JBank.Domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
