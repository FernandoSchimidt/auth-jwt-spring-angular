package com.fernando.authapijwt.controller;

import com.fernando.authapijwt.dtos.UserDto;
import com.fernando.authapijwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping("/admin")
    private String getAdmin(){
        return  "Admin OK";
    }

    @GetMapping("/user")
    private String getUser(){
        return  "User OK";
    }
}
