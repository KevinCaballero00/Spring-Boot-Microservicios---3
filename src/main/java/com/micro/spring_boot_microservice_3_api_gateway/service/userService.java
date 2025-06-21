package com.micro.spring_boot_microservice_3_api_gateway.service;

import java.util.Optional;
import com.micro.spring_boot_microservice_3_api_gateway.model.role;
import com.micro.spring_boot_microservice_3_api_gateway.model.user;

public interface userService {
    
    user saveUser(user user);
    Optional<user> findByUsername(String username);
    void changeRole(role newRole, String username);
}
