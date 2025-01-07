package com.uri.sp.app.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uri.sp.app.springboot_web.models.dto.ParamDto;
import com.uri.sp.app.springboot_web.models.dto.ParamMixDTO;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/params")
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "texto", value = "message") String message) {

        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message != null ? message : "No hay mensaje");
        return paramDto;

    }

    @GetMapping("/bar")
    public ParamDto ParamDto(@RequestParam(required = false, name = "message") String text,
            @RequestParam(required = false) Integer code) {

        ParamDto paramDto = new ParamDto();

        paramDto.setMessage(text);

        return paramDto;
    }

    @GetMapping("/request")
    public ParamMixDTO request(HttpServletRequest request) {

        Integer code = Integer.parseInt(request.getParameter("code"));

        ParamMixDTO paramMixDTO = new ParamMixDTO();

        paramMixDTO.setMessage(request.getParameter("message"));
        paramMixDTO.setCode(code);

        return paramMixDTO;
    }

}
