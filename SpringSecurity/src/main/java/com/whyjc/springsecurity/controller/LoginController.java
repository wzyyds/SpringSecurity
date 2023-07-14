package com.whyjc.springsecurity.controller;

import com.whyjc.springsecurity.entity.User;
import com.whyjc.springsecurity.service.ILoginService;
import com.whyjc.springsecurity.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }

    public static void main(String[] args) {
        String password = "uzi";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        System.out.println(encode);
    }
}

