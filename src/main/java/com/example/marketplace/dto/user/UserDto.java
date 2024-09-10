package com.example.marketplace.dto.user;

import com.example.marketplace.models.Image;
import com.example.marketplace.models.Product;
import com.example.marketplace.models.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDto {
    private Long id;

    private String email;

    private String phoneNumber;

    private String name;

    private boolean active;

    private Image avatar;

    private String password;

    private Set<Role> roles = new HashSet<>();

    private LocalDateTime dateOfCreated;

    private List<Product> products = new ArrayList<>();
}
