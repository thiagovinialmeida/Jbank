package com.thdev.JBank.DTO;

import java.time.LocalDate;

public record RequestUserDTO(
        String name,
        String email,
        String phoneNumber,
        String address,
        String cpf,
        String civilStatus,
        String profession,
        LocalDate dateOfBirth,
        char gender
) { }
