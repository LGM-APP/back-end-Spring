package com.lgm.backend.controler;



import com.lgm.backend.dto.BearerToken;
import com.lgm.backend.dto.LoginDto;
import com.lgm.backend.dto.RegisterDto;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {


    private final UserService userService;


    @RequestMapping(value="/register", method=RequestMethod.POST, produces="application/json")
    @ResponseBody
    public ResponseEntity<?> register   (@RequestBody RegisterDto registerDto){
        return userService.register(registerDto);
    }



    @RequestMapping(value="/test", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Iterable<User> test(){
        return userService.getUser();
    }



    @PostMapping("/login")
    @ResponseBody
    public BearerToken authenticate(@RequestBody LoginDto loginDto) {
        return  userService.authenticate(loginDto);
    }

}
