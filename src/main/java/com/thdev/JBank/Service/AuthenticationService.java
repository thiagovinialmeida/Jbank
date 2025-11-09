package com.thdev.JBank.Service;

import com.thdev.JBank.DTO.Login.AuthenticationDTO;
import com.thdev.JBank.DTO.Login.LoginResponseDTO;
import com.thdev.JBank.DTO.Login.RegisterDTO;
import com.thdev.JBank.Domain.User;
import com.thdev.JBank.Infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository ur;
    @Autowired
    private TokenService ts;

    public ResponseEntity loginUser(AuthenticationDTO data, Authentication auth) {
        if(ur.findByCpf(data.cpf()) != null) {
            var token = ts.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        }
        else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    public ResponseEntity registerUser(RegisterDTO data){
        if(ur.findByCpf(data.cpf()) != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        String password = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(
                data.name(),
                data.email(),
                password,
                data.phoneNumber(),
                data.address(),
                data.cpf(),
                data.civilStatus(),
                data.profession(),
                data.dateOfBirth(),
                data.gender());
        ur.save(user);

        return ResponseEntity.ok().build();
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return (UserDetails) ur.findByCpf(cpf);
    }
}
