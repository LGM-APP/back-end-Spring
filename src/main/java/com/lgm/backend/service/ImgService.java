package com.lgm.backend.service;

import com.lgm.backend.model.backendDb.FavoriteTeam;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.repository.backendDb.UserRepository;
import com.lgm.backend.security.JwtUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImgService {



    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtUtilities jwtUtilities;

    public void addProfilePhoto(String token, MultipartFile file) throws IOException {
        String email = jwtUtilities.extractUsername(token);

        Optional<User> userOptional = userService.getUser(email);

        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));

        byte[] photoBytes = file.getBytes();
        user.setProfilePhoto(photoBytes);

        userRepository.save(user);
    }


    public byte[] getProfilePhoto(String token) {
        String email = jwtUtilities.extractUsername(token);

        Optional<User> userOptional = userService.getUser(email);

        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));

        return user.getProfilePhoto();
    }

}
