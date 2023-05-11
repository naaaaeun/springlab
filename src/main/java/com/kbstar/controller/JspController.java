package com.kbstar.controller;

import com.kbstar.dto.Cust;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/jsp") // 이렇게 사용도 가능!
public class JspController {
    String dir="jsp/";
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @RequestMapping("")
    public String main(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/jsp01")
    public String jsp01(Model model) {
        model.addAttribute("num",11111);

        Cust cust=new Cust("id01","pwd", "james");
        model.addAttribute("rcust",cust);

        Date date =new Date();
        model.addAttribute("cdate",date);

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp01");
        return "index";
    }
    @RequestMapping("/jsp02")
    public String jsp02(Model model) {
        model.addAttribute("num",1);
        Cust cust=new Cust("id01","pwd", "james");
        model.addAttribute("rcust",cust);
        Date date =new Date();
        model.addAttribute("cdate",date);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp02");
        return "index";
    }
    @RequestMapping("/jsp03")
    public String jsp03(Model model) {
        List<Cust> list=new ArrayList<>();
        list.add(new Cust("id01","pwd" , "james1"));
        list.add(new Cust("id02","pwd" ,"james2"));
        list.add(new Cust("id03","pwd" ,"james3"));
        list.add(new Cust("id04","pwd" ,"james4"));
        list.add(new Cust("id05","pwd" ,"james5"));
        model.addAttribute("clist",list);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp03");
        return "index";
    }
    @RequestMapping("/jsp04")
    public String jsp04(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp04");
        return "index";
    }
    @RequestMapping("/jsp05")
    public String jsp05(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp05");
        return "index";
    }

}