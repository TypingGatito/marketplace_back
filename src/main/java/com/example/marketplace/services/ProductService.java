package com.example.marketplace.services;

import com.example.marketplace.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> products(String title);

    void save(Product product,
              MultipartFile image1,
              MultipartFile image2,
              MultipartFile image3) throws IOException;

    void remove(long id);

    Product get(long id);
}
