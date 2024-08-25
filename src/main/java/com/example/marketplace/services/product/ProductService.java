package com.example.marketplace.services.product;

import com.example.marketplace.models.Product;
import com.example.marketplace.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface ProductService {

    List<Product> products(String title);

    void save(Principal principal,
              Product product,
              MultipartFile image1,
              MultipartFile image2,
              MultipartFile image3) throws IOException;

    void remove(long id);

    Product get(long id);

    User getUserByPrincipal(Principal principal);
}
