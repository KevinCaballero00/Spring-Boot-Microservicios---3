package com.micro.spring_boot_microservice_3_api_gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.micro.spring_boot_microservice_3_api_gateway.model.user;
import com.micro.spring_boot_microservice_3_api_gateway.security.userPrincipal;
import com.micro.spring_boot_microservice_3_api_gateway.security.jwt.jwtProvider;

@Service
public class AuthenticationServiceImpl implements authenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtProvider jwtProvider;
    
    @Override
    public user signInAndReturnJWT(user signInRequest){

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                signInRequest.getUsername(), 
                signInRequest.getPassword()
            )
        );

        userPrincipal userPrincipal = (userPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        user signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }
    
}
    

