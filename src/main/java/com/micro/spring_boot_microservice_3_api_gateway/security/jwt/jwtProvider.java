package com.micro.spring_boot_microservice_3_api_gateway.security.jwt;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import com.micro.spring_boot_microservice_3_api_gateway.security.userPrincipal;

import jakarta.servlet.http.HttpServletRequest;

public interface jwtProvider {
    
    String generateToken(userPrincipal auth);
    
    org.springframework.security.core.Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
