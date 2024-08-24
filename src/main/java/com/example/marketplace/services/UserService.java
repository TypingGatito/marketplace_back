package com.example.marketplace.services;

import com.example.marketplace.models.User;
import com.example.marketplace.models.enums.Role;
import com.example.marketplace.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public boolean createUser(@NonNull User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            return false;
        }

        user.setActive(true);
        user.getRoles().add(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        log.info("User created with email: {}", user.getEmail());
        return true;
    }
}
