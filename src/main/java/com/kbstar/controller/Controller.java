package com.kbstar.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/") // ==http://127.0.0.1/
    public String main(){
        return "index";
    }
    @RequestMapping("/next") // ==http://127.0.0.1/
    public String next(){
        return "next";
    }
}
