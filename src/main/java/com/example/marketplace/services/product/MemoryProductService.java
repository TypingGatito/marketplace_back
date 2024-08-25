package com.example.marketplace.services.product;

import com.example.marketplace.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoryProductService{
    private long ID = 0;
    private List<Product> products = new ArrayList<>();

    public List<Product> products() {
        return products;
    }

    public void save(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void remove(long id) {
        products.removeIf((Product product) -> product.getId() == id);
    }

    public Product get(long id) {
        return products.stream()
                .filter((Product product) -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
