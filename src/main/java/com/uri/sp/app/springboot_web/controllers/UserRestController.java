package com.uri.sp.app.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uri.sp.app.springboot_web.models.User;
import com.uri.sp.app.springboot_web.models.dto.UserDto;

@RestController
public class UserRestController {

    @GetMapping("/detailsrest")
    public UserDto details() {
        UserDto userDto = new UserDto();

        User user = new User("Uriel", "Arriaga");

        userDto.setUser(user);
        userDto.setTitle("Hola Mundo desde Thymeleaf");

        return userDto;

    }

    @GetMapping("/listjson")
    public List<User> list() {
        User user = new User("Uriel", "Arriaga");

        User user2 = new User("andres", "x");

        User user3 = new User("pepe", "a");

        // List<User> users = new ArrayList<>();

        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        // List<User> users = List.of(user, user2, user3);

        List<User> users = Arrays.asList(user, user2, user3);

        return users;

    }

    @GetMapping("/detailsrestdto")
    public Map<String, Object> detailsdto() {

        User user = new User("Uriel", "Arriaga");

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo desde Thymeleaf");
        body.put("user", user);

        return body;

    }

}
