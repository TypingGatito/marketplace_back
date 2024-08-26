package com.example.marketplace.controllers;

import com.example.marketplace.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    private final UserService userService;

    @GetMapping
    public String admin(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "admin";
    }

    @PostMapping("/user/ban/{id}")
    public String userBan(@PathVariable Long id) {
        userService.userBan(id);

        return "redirect:/admin";
    }

    @GetMapping("/admin/user/edit/{id}")
    public String userEdit(@PathVariable Long id, Model model) {
        return "redirect:/admin";
    }
}
