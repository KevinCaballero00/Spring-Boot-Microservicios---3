package com.micro.spring_boot_microservice_3_api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.micro.spring_boot_microservice_3_api_gateway.model.user;
import com.micro.spring_boot_microservice_3_api_gateway.service.authenticationService;
import com.micro.spring_boot_microservice_3_api_gateway.service.userService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("api/authentication")
public class authenticationController {

    @Autowired
    private authenticationService authenticationService;

    @Autowired
    private userService userService;
    
    
    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody user user) {
        
        if(userService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody user user) {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
    
}
    
    

