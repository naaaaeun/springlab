package com.kbstar.controller;

import com.kbstar.dto.CustDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login");
        return "index";
    }
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd){
        logger.info(id+" "+pwd);
        model.addAttribute("center", "login");
        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register");
        return "index";
    }
    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, CustDTO cust){  //변수 너무 많은 경우에는 이렇게! 담아서 한번에 보내자.
        logger.info(cust+""); // info는 항상 문자열이어야 한다.
        model.addAttribute("rcust", cust);
        model.addAttribute("center", "registerok");
        return "index";
    }
}
