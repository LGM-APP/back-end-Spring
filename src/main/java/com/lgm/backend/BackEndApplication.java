package com.lgm.backend;

import com.lgm.backend.model.backendDb.Role;
import com.lgm.backend.model.backendDb.RoleName;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.repository.backendDb.RoleRepository;
import com.lgm.backend.repository.backendDb.UserRepository;
import com.lgm.backend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }


    @Bean
    CommandLineRunner run (UserService userService , RoleRepository roleRepository , UserRepository userRepository , PasswordEncoder passwordEncoder)
    {return  args ->
    {   userService.saveRole(new Role(RoleName.USER));
        userService.saveRole(new Role(RoleName.ADMIN));
        userService.saveRole(new Role(RoleName.SUPERADMIN));
        userService.saveUser(new User("admin","admin","admin@gmail.com", passwordEncoder.encode("adminPassword"), new ArrayList<>()));
        userService.saveUser(new User("superadmin","superadmin","superadminadmin@gmail.com", passwordEncoder.encode("superadminPassword"), new ArrayList<>()));

        Role role = roleRepository.findByRoleName(RoleName.ADMIN);
        User user = userRepository.findByEmail("admin@gmail.com").orElse(null);
        user.getRoles().add(role);
        userService.saveUser(user);

        User userr = userRepository.findByEmail("superadminadmin@gmail.com").orElse(null);
        Role rolee = roleRepository.findByRoleName(RoleName.SUPERADMIN);
        userr.getRoles().add(rolee);
        userService.saveUser(userr);

    };}

}
