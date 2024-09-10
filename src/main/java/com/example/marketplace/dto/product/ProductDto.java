package com.example.marketplace.dto.product;

import com.example.marketplace.models.Image;
import com.example.marketplace.models.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDto {
    private Long id;

    private String title;

    private String description;

    private int price;

    private String city;

    private List<Image> images = new ArrayList<>();

    private Long previewImageId;

    private LocalDateTime timeOfCreation;

    private User user;
}
