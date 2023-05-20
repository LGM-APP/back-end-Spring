package com.lgm.backend.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeploymendTest {


    @GetMapping("/deployment")
    public String testLogin(){
        return "deployé22";
    }

}
