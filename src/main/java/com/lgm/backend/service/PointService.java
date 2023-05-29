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

    public void add(Float point, String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()){

            User user = optionalUser.get();
            Float newPoint = user.getPoint() + point;
            user.setPoint(newPoint);

        }
    }

    public void addPointOdd(Float odd, Float point, String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()){

            User user = optionalUser.get();
            float newPoint = user.getPoint() + point*odd;
            user.setPoint(newPoint);

        }
    }

    public void remove(Float point,String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()){

            User user = optionalUser.get();
            Float newPoint = user.getPoint() - point;
            user.setPoint(newPoint);

        }
    }

    public Float getPoint(String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()){

            User user = optionalUser.get();
            return user.getPoint();

        }
        return null;
    }

}
