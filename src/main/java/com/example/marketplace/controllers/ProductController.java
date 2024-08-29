package com.example.marketplace.controllers;

import com.example.marketplace.models.Product;
import com.example.marketplace.models.User;
import com.example.marketplace.services.UserService;
import com.example.marketplace.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    @GetMapping("")
    public String products(@RequestParam(name= "searchWord", required = false) String title,
                           Model model,
                           Principal principal) {
        model.addAttribute("products", productService.products(title));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("title", title);
        return "products";
    }

    @GetMapping("/{id}")
    public String productInfo(@PathVariable Long id, Model model, Principal principal) {
        Product product = productService.get(id);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        model.addAttribute("authorProduct", product.getUser());
        return "product-info";
    }

    @PostMapping("/create")
    public String createProduct(@RequestParam(name = "file1") MultipartFile file1,
                                @RequestParam(name = "file2") MultipartFile file2,
                                @RequestParam(name = "file3") MultipartFile file3,
                                Product product,
                                Principal principal) throws IOException {
        productService.save(principal, product, file1, file2, file3);

        return "redirect:/product";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.remove(id);
        return "redirect:/product";
    }

    @GetMapping("/my/products")
    public String userProducts(Principal principal, Model model) {
        User user = productService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("products", user.getProducts());
        return "my-products";
    }
}
