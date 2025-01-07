package com.uri.sp.app.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.uri.sp.app.springboot_web.models.User;
import com.uri.sp.app.springboot_web.models.dto.ParamDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }

    @GetMapping("/baz/{message}/{id}")
    public ParamDto bazMix(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {

        return user;
    }

}
