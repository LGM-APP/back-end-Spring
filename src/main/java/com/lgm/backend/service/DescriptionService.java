package com.lgm.backend.service;

import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.repository.backendDb.UserRepository;
import com.lgm.backend.security.JwtUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DescriptionService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtUtilities jwtUtilities;

    public void addDescription(String token, String description) {
        String email = jwtUtilities.extractUsername(token);

        Optional<User> userOptional = userService.getUser(email);

        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));

        user.setDescription(description);

        userRepository.save(user);
    }

    public String getDescription(String token) {

        String email = jwtUtilities.extractUsername(token);

        Optional<User> userOptional = userService.getUser(email);

        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));

        return user.getDescription();
    }

}
