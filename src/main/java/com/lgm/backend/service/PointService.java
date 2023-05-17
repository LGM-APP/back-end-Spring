package com.lgm.backend.service;

import com.lgm.backend.repository.backendDb.PointRepository;
import com.lgm.backend.repository.backendDb.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;
    private final UserRepository userRepository;





}
