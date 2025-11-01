package com.thdev.JBank.Infrastructure;


import com.thdev.JBank.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByCpf(String cpf);
}
