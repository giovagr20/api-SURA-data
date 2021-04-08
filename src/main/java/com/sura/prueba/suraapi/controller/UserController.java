package com.sura.prueba.suraapi.controller;

import com.sura.prueba.suraapi.model.UserModel;
import com.sura.prueba.suraapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return userService.findAll();
    }
}
