package com.webapp.mensaapp.authentication.controller;

import com.webapp.mensaapp.authentication.Bean.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/basicauth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationBeanController {


    @GetMapping
    public AuthenticationBean authenticating() {
       return new AuthenticationBean("You are authenticated");
    }

}
