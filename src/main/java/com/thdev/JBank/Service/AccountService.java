package com.thdev.JBank.Service;

import com.thdev.JBank.DTO.RequestUserDTO;
import com.thdev.JBank.Domain.User;
import com.thdev.JBank.Infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private static UserRepository ur;

    public ResponseEntity<Void> CreateAccount(RequestUserDTO data) {
        if(validateCpf(data.cpf())){
            //throw new IllegalArgumentException("CPF já cadastrado.");
            return ResponseEntity.badRequest().build();
        } else {
            User newUser = new User(
                    data.name(),
                    data.email(),
                    data.password(),
                    data.phoneNumber(),
                    data.address(),
                    data.cpf(),
                    data.civilStatus(),
                    data.profession(),
                    data.dateOfBirth(),
                    data.gender());
            ur.save(newUser);
            return ResponseEntity.ok().build();
        }
    }
    public static void ReadAccount() {}
    public static void DeleteAccount() {}
    public static void UpdateAccount() {}

    private static boolean validateCpf(String cpf) {
        //True = Existe
        //False = Não existe
        return ur.findByCpf(cpf) != null;
    }
}
