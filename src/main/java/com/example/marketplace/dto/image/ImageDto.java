package com.example.marketplace.dto.image;

import com.example.marketplace.models.Product;
import lombok.Data;

@Data
public class ImageDto {
    private Long id;
    private String name;
    private String originalFileName;
    private Long size;
    private String contentType;
    private boolean isPreviewImage;
    private byte[] imageData;
    private Product product;
}

