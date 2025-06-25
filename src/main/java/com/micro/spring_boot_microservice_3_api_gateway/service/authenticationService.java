package com.micro.spring_boot_microservice_3_api_gateway.service;

import com.micro.spring_boot_microservice_3_api_gateway.model.user;

public interface authenticationService {
    
    user signInAndReturnJWT(user signInRequest);
}
