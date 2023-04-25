package com.kbstar.controller;

import com.kbstar.dto.CustDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/cust") // 이렇게 사용도 가능!
public class CustController {
    String dir="cust/";
    //Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @RequestMapping("")
    public String main(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        //logger.info("=-------------------------------");
        Random r =new Random();
        int inx=r.nextInt(1000)+1;
        log.info(""+inx);
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
        list.add(new CustDTO("id01","pwd" , "james1"));
        list.add(new CustDTO("id02","pwd" ,"james2"));
        list.add(new CustDTO("id03","pwd" ,"james3"));
        list.add(new CustDTO("id04","pwd" ,"james4"));
        list.add(new CustDTO("id05","pwd" ,"james5"));
        model.addAttribute("clist",list);

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"all");
        return "index";
    }
    @RequestMapping("/get")
    public String get(Model model, String id) {
        CustDTO cust = new CustDTO("id","xxx", "james");
        model.addAttribute("gcust",cust);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "index";
    }

}