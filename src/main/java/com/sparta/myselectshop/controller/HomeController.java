package com.sparta.myselectshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")//localhost:8080/로 접속하면 index.html로 연결
    public String home() {
        return "index";
    }
}