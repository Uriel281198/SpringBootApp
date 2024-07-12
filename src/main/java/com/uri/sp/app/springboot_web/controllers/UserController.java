package com.uri.sp.app.springboot_web.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/detailsmap")
    public String detailsmap(Map<String, Object> model) {
        model.put("title", "Hola Mundo desde Thymeleaf");
        return "details";
    }

}
