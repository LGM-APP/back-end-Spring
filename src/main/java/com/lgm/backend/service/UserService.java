package com.lgm.backend.service;


import com.lgm.backend.dto.BearerToken;
import com.lgm.backend.dto.LoginDto;
import com.lgm.backend.dto.RegisterDto;
import com.lgm.backend.model.backendDb.Role;
import com.lgm.backend.model.backendDb.RoleName;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.model.mainDb.VideoGame;
import com.lgm.backend.repository.backendDb.RoleRepository;
import com.lgm.backend.repository.backendDb.UserRepository;
import com.lgm.backend.repository.mainDb.VideoGameRepository;
import com.lgm.backend.security.JwtUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final VideoGameRepository videoGameRepository;

    private final JwtUtilities jwtUtilities;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public Role saveRole (Role role){
        return roleRepository.save(role);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Iterable<User> getUser(){
        return userRepository.findAll();
    }


    public Iterable<VideoGame> videoGame(){
        return videoGameRepository.findAll();
    }

    public ResponseEntity<?> register(RegisterDto registerDto) {
        if(userRepository.existsByEmail(registerDto.getEmail()))
        { return  new ResponseEntity<>("email is already taken !", HttpStatus.SEE_OTHER); }
        else
        { User user = new User();


            user.setEmail(registerDto.getEmail());
            user.setFirstName(registerDto.getFirstName());
            user.setLastName(registerDto.getLastName());
            user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

            Role role = roleRepository.findByRoleName(RoleName.USER);
            user.setRoles(Collections.singletonList(role));
            userRepository.save(user);
            String token = jwtUtilities.generateToken(registerDto.getEmail(),Collections.singletonList(role.getRoleName()));
            return new ResponseEntity<>(new BearerToken(token , "Bearer "),HttpStatus.OK);
        }
    }


    public BearerToken authenticate(LoginDto loginDto) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByEmail(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<String> rolesNames = new ArrayList<>();
        user.getRoles().forEach(r-> rolesNames.add(r.getRoleName()));
        String token = jwtUtilities.generateToken(user.getUsername(),rolesNames);
        return new BearerToken(token,"bearer");
    }


}

