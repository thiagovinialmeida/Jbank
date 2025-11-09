package com.thdev.JBank.Controller;

import com.thdev.JBank.DTO.RequestUserDTO;
import com.thdev.JBank.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private AccountService as;

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<RequestUserDTO> getBalance(@PathVariable String cpf) {
        return as.getAccountInfo(cpf);
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity DeleteAccount(@PathVariable String cpf) {
        return as.DeleteAccount(cpf);
    }

    @PutMapping
    public ResponseEntity<Void> UpdateAccount(@RequestBody RequestUserDTO data) {
        return as.UpdateAccount(data);
    }
}
