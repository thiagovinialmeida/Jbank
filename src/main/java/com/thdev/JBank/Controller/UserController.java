package com.thdev.JBank.Controller;

import com.thdev.JBank.DTO.RequestUserDTO;
import com.thdev.JBank.Service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private AccountService as;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody RequestUserDTO data) {
        return as.CreateAccount(data);
    }
}
