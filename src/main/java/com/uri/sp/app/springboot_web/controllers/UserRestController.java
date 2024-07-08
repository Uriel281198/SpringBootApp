package com.uri.sp.app.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @GetMapping("/detailsrest")
    public Map<String, Object> details() {
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo desde Thymeleaf");

        return body;

    }

}
