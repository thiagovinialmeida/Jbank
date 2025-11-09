package com.thdev.JBank.DTO.Login;

public record AuthenticationDTO (
        String cpf,
        String email,
        String password
) { }
