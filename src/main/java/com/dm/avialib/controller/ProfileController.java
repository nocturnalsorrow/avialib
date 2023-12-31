package com.dm.avialib.controller;

import com.dm.avialib.entity.User;
import com.dm.avialib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    private  final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getProfile(Authentication authentication, Model model) {
        model.addAttribute("user", userService.getUserByEmail(authentication.getName()));

        return  "profile";
    }

    @PostMapping("/profile/edit")
    public String edit(@ModelAttribute User updatedUser, Authentication authentication){
        userService.updateUser(updatedUser, authentication);

        return "redirect:/profile";
    }
}
