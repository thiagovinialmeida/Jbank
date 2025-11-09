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
    private UserRepository ur;

    public ResponseEntity<RequestUserDTO> getAccountInfo(String cpf) {
        User user = ur.findByCpf(cpf);
        RequestUserDTO dto = new RequestUserDTO(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getBalance(),
                user.getCpf(),
                user.getCivilStatus(),
                user.getProfession(),
                user.getDateOfBirth(),
                user.getGender());
        return ResponseEntity.ok(dto);
    }

    public ResponseEntity DeleteAccount(String cpf) {
        User user = ur.findByCpf(cpf);

        if (user != null) {
            ur.delete(user);
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity UpdateAccount(RequestUserDTO data) {
        User user = ur.findByCpf(data.cpf());
        if (user != null) {
            user.setName(data.name());
            user.setEmail(data.email());
            user.setPassword(data.password());
            user.setPhoneNumber(data.phoneNumber());
            user.setAddress(data.address());
            user.setCivilStatus(data.civilStatus());
            user.setProfession(data.profession());
            user.setDateOfBirth(data.dateOfBirth());
            user.setGender(data.gender());

            return ResponseEntity.ok("Updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
