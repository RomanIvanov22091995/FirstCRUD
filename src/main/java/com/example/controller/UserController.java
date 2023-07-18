package com.example.controller;

import com.example.models.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String showCreateUserForm() {
        return "createUser";
    }

    @PostMapping("/create")
    public String createUser(@RequestParam("name") String name) {
        User user = new User(name);
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/edit")
    public String showEditUserForm(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit")
    public String updateUser(@RequestParam("id") Long id, @RequestParam("name") String name) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setName(name);
            userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}