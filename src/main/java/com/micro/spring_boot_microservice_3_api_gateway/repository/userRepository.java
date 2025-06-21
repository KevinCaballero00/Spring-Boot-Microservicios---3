package com.micro.spring_boot_microservice_3_api_gateway.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.micro.spring_boot_microservice_3_api_gateway.model.role;
import com.micro.spring_boot_microservice_3_api_gateway.model.user;

import feign.Param;

public interface userRepository extends JpaRepository<user, Long>{
    
    //findBy + nombreDelCampo
    Optional<user> findByUsername(String username);

    @Modifying
    @Query("update User set role=:role where username=:username")
    void updateUserRole(@Param("username") String username, @Param("role") role role);
    
}
