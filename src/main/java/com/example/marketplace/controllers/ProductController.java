package com.example.marketplace.controllers;

import com.example.marketplace.models.Product;
import com.example.marketplace.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public String products(@RequestParam(name="title", required = false) String title, Model model) {
        model.addAttribute("products", productService.products(title));
        return "products";
    }

    @PostMapping("/create")
    public String createProduct(@RequestParam(name = "file1") MultipartFile file1,
                                @RequestParam(name = "file2") MultipartFile file2,
                                @RequestParam(name = "file3") MultipartFile file3,
                                    Product product) throws IOException {
        productService.save(product, file1, file2, file3);

        return "redirect:/product";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.remove(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }
}
