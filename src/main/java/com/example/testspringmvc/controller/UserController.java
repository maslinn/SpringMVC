package com.example.testspringmvc.controller;

import com.example.testspringmvc.entity.User;
import com.example.testspringmvc.model.UsersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UsersList usersList;
    private final User user;

    @Autowired
    public UserController(UsersList usersList, User user) {
        this.usersList = usersList;
        this.user = user;
    }


    @GetMapping("/form")
    public String getUserForm(Model model) {
        model.addAttribute("user", user);
        return "user_form";
    }

    @PostMapping("/user")
    public String saveUserFromForm(User user) {
        usersList.setUser(user);
        return "redirect:/form";
    }

    @GetMapping("/user/{name}")
    public String getUser(@PathVariable String name, Model model) {
        model.addAttribute("user", usersList.getUserByName(name));
        return "user";
    }

}
