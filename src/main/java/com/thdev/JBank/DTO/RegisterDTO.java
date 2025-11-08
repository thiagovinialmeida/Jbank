package com.thdev.JBank.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record RegisterDTO(
        String name,
        String email,
        String password,
        String phoneNumber,
        String address,
        String cpf,
        String civilStatus,
        String profession,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dateOfBirth,
        char gender
) { }
