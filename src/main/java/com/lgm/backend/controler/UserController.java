package com.lgm.backend.controler;



import com.lgm.backend.dto.BearerToken;
import com.lgm.backend.dto.LoginDto;
import com.lgm.backend.dto.RegisterDto;
import com.lgm.backend.dto.UserDto;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.security.JwtUtilities;
import com.lgm.backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {


    private final UserService userService;
    private final JwtUtilities jwtUtilities;
    private final ModelMapper modelMapper;

    @RequestMapping(value="/test", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Iterable<User> test(){
        return userService.getUser();
    }

    @RequestMapping(value="/register", method=RequestMethod.POST, produces="application/json")
    @ResponseBody
    public ResponseEntity<?> register   (@RequestBody RegisterDto registerDto){
        return userService.register(registerDto);
    }


    @PostMapping("/login")
    @ResponseBody
    public BearerToken authenticate(@RequestBody LoginDto loginDto) {
        return  userService.authenticate(loginDto);
    }


    @GetMapping("/get")
    public UserDto getUser(@NonNull HttpServletRequest request){
        return modelMapper.map(userService.getUser(jwtUtilities.extractUsername(jwtUtilities.getToken(request))).orElse(new User(null,null,null,null,null)), UserDto.class);
    }
}
