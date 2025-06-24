package com.micro.spring_boot_microservice_3_api_gateway.security;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.micro.spring_boot_microservice_3_api_gateway.service.userService;
import com.micro.spring_boot_microservice_3_api_gateway.utils.securityUtils;
import com.micro.spring_boot_microservice_3_api_gateway.model.user;

@Service
public class customUserDetailsService implements UserDetailsService{

    @Autowired
    private userService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        user user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        
        Set<GrantedAuthority> authorities = Set.of(securityUtils.convertToAuthority(user.getRole().name()));
        
        return userPrincipal.builder()
                .user(user)
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
    
}
