package com.micro.spring_boot_microservice_3_api_gateway.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.micro.spring_boot_microservice_3_api_gateway.model.role;
import com.micro.spring_boot_microservice_3_api_gateway.model.user;
import com.micro.spring_boot_microservice_3_api_gateway.repository.userRepository;

import jakarta.transaction.Transactional;

@Service
public class userServiceImp implements userService {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public user saveUser(user user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role.USER);
        user.setFechaCreacion(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public Optional<user> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void changeRole(role newRole, String username) {
        userRepository.updateUserRole(username, newRole);
    }
}
