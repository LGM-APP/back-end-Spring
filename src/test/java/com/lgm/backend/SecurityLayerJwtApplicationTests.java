package com.lgm.backend;

import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.repository.backendDb.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SecurityLayerJwtApplicationTests {


    @Autowired
    private UserRepository userRepository;


    @Test
    void contextLoads() {






    }

}