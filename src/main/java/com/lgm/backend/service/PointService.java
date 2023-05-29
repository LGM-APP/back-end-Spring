package com.lgm.backend.service;


import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.repository.backendDb.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PointService {

    private final UserRepository userRepository;

    public void add(Integer point,String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()){

            User user = optionalUser.get();
            Integer newPoint = user.getPoint() + point;
            user.setPoint(newPoint);

        }
    }

    public void remove(Integer point,String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()){

            User user = optionalUser.get();
            Integer newPoint = user.getPoint() + point;
            user.setPoint(newPoint);

        }
    }

    public Integer getPoint(String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()){

            User user = optionalUser.get();
            return user.getPoint();

        }
        return null;
    }

}
