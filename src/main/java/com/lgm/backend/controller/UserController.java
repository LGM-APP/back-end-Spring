package com.lgm.backend.controller;



import com.lgm.backend.dto.BearerToken;
import com.lgm.backend.dto.LoginDto;
import com.lgm.backend.dto.RegisterDto;
import com.lgm.backend.dto.UserDto;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.security.JwtUtilities;
import com.lgm.backend.service.DescriptionService;
import com.lgm.backend.service.ImgService;
import com.lgm.backend.service.PointService;
import com.lgm.backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {


    private final UserService userService;
    private final JwtUtilities jwtUtilities;
    private final ModelMapper modelMapper;
    private final PointService pointService;
    private final ImgService imgService;
    private final DescriptionService descriptionService;


    @RequestMapping(value="/register", method=RequestMethod.POST, produces="application/json")
    @ResponseBody
    public ResponseEntity<?> register   (@RequestBody RegisterDto registerDto){
        return userService.register(registerDto);
    }

    @PostMapping("/addPoint/{point}")
    public void addPoint(@NonNull HttpServletRequest request,@PathVariable("point")Float point){
        pointService.add(point, jwtUtilities.extractUsername(jwtUtilities.getToken(request)));
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

    @GetMapping("/ranking")
    public List<UserDto> getRanking(){
        return userService.getRanking().stream().map((element) -> modelMapper.map(element, UserDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/ProfilePicture")
    public ResponseEntity<String> addProfilePhoto(@NonNull HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty");
            }

            if (!StringUtils.hasText(file.getContentType()) || !file.getContentType().startsWith("image/")) {
                return ResponseEntity.badRequest().body("Invalid file type. Only images are allowed.");
            }

            imgService.addProfilePhoto(jwtUtilities.getToken(request), file);
            return ResponseEntity.ok("Profile photo added successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add profile photo.");
        }
    }

    @GetMapping("/ProfilePicture")
    public ResponseEntity<byte[]> getProfilePhoto(@NonNull HttpServletRequest request) {
        byte[] photoData = imgService.getProfilePhoto(jwtUtilities.getToken(request));
        if (photoData != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(photoData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/description")
    public ResponseEntity<String> addDescription(@NonNull HttpServletRequest request, @RequestBody String description) {
        try {
            descriptionService.addDescription(jwtUtilities.getToken(request), description);
            return ResponseEntity.ok("Description added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add description.");
        }
    }


}
