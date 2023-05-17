package com.lgm.backend.security;

import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.repository.backendDb.UserRepository;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository ;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found !"));
        return  user ;    }
}
