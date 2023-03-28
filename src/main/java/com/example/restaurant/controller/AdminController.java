package com.example.restaurant.controller;

import com.example.restaurant.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserServiceImpl users;

    @GetMapping("/")
    public String registrationForm() {
        return "admin";
    }

    @GetMapping("/list-user")
    public String listAll(Model model){
//        List<User> listAllUser = users.getAllUser();
        model.addAttribute("listUser", users.getAllUser());
        return "listUser";
    }
}
