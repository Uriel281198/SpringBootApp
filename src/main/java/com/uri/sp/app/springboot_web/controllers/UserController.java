package com.uri.sp.app.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.uri.sp.app.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Uriel", "Arriaga");
        model.addAttribute("title", "Hola Mundo desde Thymeleaf");
        model.addAttribute("subtitle", "Subtítulo de la página");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {

        // List<User> users = new ArrayList<>();

        List<User> users = Arrays.asList(
        // new User("Uriel", "Arriaga"),
        // new User("John", "Doe", "jon@gmail.com"),
        // new User("Jane", "Doe")

        );

        // model.addAttribute("users", users);
        model.addAttribute("title", "Lista de Usuarios");
        return "list";
    }

    @GetMapping("/detailsmap")
    public String detailsmap(Map<String, Object> model) {
        model.put("title", "Hola Mundo desde Thymeleaf");
        return "details";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        List<User> users = Arrays.asList(
                new User("Uriel", "Arriaga"),
                new User("John", "Doe", "jon@gmail.com"),
                new User("Jane", "Doe"));

        return users;

    }

}
