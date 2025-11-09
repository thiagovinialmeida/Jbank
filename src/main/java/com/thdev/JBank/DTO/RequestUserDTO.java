package com.thdev.JBank.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RequestUserDTO(
        String name,
        String email,
        String password,
        String phoneNumber,
        String address,
        BigDecimal balance,
        String cpf,
        String civilStatus,
        String profession,
        LocalDate dateOfBirth,
        char gender
) { }
