package com.lgm.backend.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestLogin {

    @GetMapping("/testlogin")
    public String testLogin(){
        return "check";
    }

}
