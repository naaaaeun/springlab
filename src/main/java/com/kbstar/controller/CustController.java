package com.kbstar.controller;

import com.kbstar.dto.CustDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cust") // 이렇게 사용도 가능!
public class CustController {
    String dir="cust/";
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @RequestMapping("")
    public String main(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }
    @RequestMapping("/all")
    public String all(Model model) {
        List<CustDTO> list=new ArrayList<>();
        list.add(new CustDTO("id01","pwd" ,"pwd", "james1"));
        list.add(new CustDTO("id02","pwd" ,"pwd", "james2"));
        list.add(new CustDTO("id03","pwd" ,"pwd", "james3"));
        list.add(new CustDTO("id04","pwd" ,"pwd", "james4"));
        list.add(new CustDTO("id05","pwd" ,"pwd", "james5"));
        model.addAttribute("clist",list);

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"all");
        return "index";
    }
    @RequestMapping("/get")
    public String get(Model model, String id) {
        CustDTO cust = new CustDTO("id","xxx", "xxx","james");
        model.addAttribute("gcust",cust);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "index";
    }

}