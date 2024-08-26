package com.example.marketplace.services;

import com.example.marketplace.models.User;
import com.example.marketplace.models.enums.Role;
import com.example.marketplace.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
        ///user.getRoles().add(Role.USER);
        user.getRoles().add(Role.ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        log.info("User created with email: {}", user.getEmail());
        return true;
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void userBan(Long userId) {
        User user = getById(userId);

        if (user != null) {
            user.setActive(false);
            log.info("User banned with id: {}", userId);
        }

        userRepository.save(user);
    }
}
