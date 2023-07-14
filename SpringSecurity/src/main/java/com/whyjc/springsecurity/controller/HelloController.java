package com.whyjc.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :Yijc
 * @Date :2023/7/13
 */

@RestController
public class HelloController {


    @RequestMapping("/hello")
    @PreAuthorize("@ex.hasAuthority('system:dept:list')")
    public String  hello(){
        return "hello";
    }
}
