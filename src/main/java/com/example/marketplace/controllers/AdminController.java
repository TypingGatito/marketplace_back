package com.example.marketplace.controllers;

import com.example.marketplace.models.User;
import com.example.marketplace.models.enums.Role;
import com.example.marketplace.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
@Slf4j
public class AdminController {
    private final UserService userService;

    @GetMapping
    public String admin(Principal principal, Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "admin";
    }

    @PostMapping("/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id) {
        userService.userBan(id);
        log.info("User Banned " + id);

        return "redirect:/admin";
    }

    @GetMapping("/user/edit/{id}")
    public String userEdit(@PathVariable Long id, Model model, Principal principal) {
        User user = userService.getById(id);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("userToEdit", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }

    @PostMapping("/user/edit")
    public String userEdit(@RequestParam(name = "id") Long id, @RequestParam Map<String, String> params) {
        log.info("params {}", params);
        User user = userService.getById(id);

        userService.changeUserRoles(user, params);
        return "redirect:/admin";
    }
}
