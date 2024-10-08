package com.example.marketplace.services.product;

import com.example.marketplace.models.Image;
import com.example.marketplace.models.Product;
import com.example.marketplace.models.User;
import com.example.marketplace.repository.ProductRepository;
import com.example.marketplace.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@Primary
@RequiredArgsConstructor
public class DbProductService implements ProductService {
    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    @Override
    public void save(Principal principal,
                     Product product,
                     MultipartFile file1,
                     MultipartFile file2,
                     MultipartFile file3) throws IOException {
        product.setUser(getUserByPrincipal(principal));

        Image image1;
        Image image2;
        Image image3;

        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImage(image1);
        }

        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImage(image2);
        }

        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImage(image3);
        }


        log.info("Saving new Product. Title: {}; Author: {}", product.getTitle(), product.getUser().getEmail());

        Product savedProduct = productRepository.save(product);
        savedProduct.setPreviewImageId(savedProduct.getImages().get(0).getId());
        productRepository.save(product);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    @Override
    public void remove(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product get(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> products(String title) {
        return title == null ? productRepository.findAll() : productRepository.findByTitle(title);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setSize(file.getSize());
        image.setContentType(file.getContentType());
        image.setImageData(file.getBytes());

        return image;
    }
}
