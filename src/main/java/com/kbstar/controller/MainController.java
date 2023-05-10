package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import com.kbstar.util.WeatherUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @Value("${adminserver}")
    String adminServer;

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Autowired
    private BCryptPasswordEncoder encoder; //로그인 시 pwd 암호화를 위한 변수 선언.

    @Autowired
    CustService custService;
    @RequestMapping("/")

    public String main(Model model) throws Exception {
        String result= WeatherUtil.getWeather1("109");
        model.addAttribute("weatherinfo", result);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login");
        return "index";
    }
    @RequestMapping("/pic")
    public String pic(Model model){
        model.addAttribute("center", "pic");
        return "index";
    }
    @RequestMapping("/custinfo")
    public String custinfo(Model model, String id) throws Exception {
        Cust cust=null;
        try {
            cust = custService.get(id);
        }catch (Exception e){
            throw new Exception("시스템 장애. 잠시 후 다시 로그인 하세요");
        }
        model.addAttribute("custinfo", cust);
        model.addAttribute("center", "custinfo");
        return "index";
    }
    @RequestMapping("/custinfoimpl")
    public String custinfoimpl(Model model,Cust cust) throws Exception {
        try {
            cust.setPwd(encoder.encode(cust.getPwd()));
            custService.modify(cust);
        }catch (Exception e){
            throw new Exception("시스템 장애. 잠시 후 다시 로그인 하세요");
        }
        return "redirect:/custinfo?id="+cust.getId() ;
    }
    @RequestMapping("/logout")
    public String logout(Model model,HttpSession session){
        if(session !=null){
            session.invalidate(); //세션 끊을게요.
        }
        return "index";
    }
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd, HttpSession session) throws Exception {
        logger.info(id+" "+pwd);
        Cust cust=null;
        String nextPage="loginfail";
        try {
            cust = custService.get(id);
            if(cust !=null && encoder.matches(pwd,cust.getPwd())){
                nextPage="loginok";
                session.setMaxInactiveInterval(100000); //100초간 세션 유지할게요.
                session.setAttribute("logincust", cust);

                //세션과 모델 모두 달러 사인으로 꺼낼 수 있어요.
            }
        }catch (Exception e){
            throw new Exception("시스템 장애. 잠시 후 다시 로그인 하세요");
        }
        model.addAttribute("center", nextPage);
        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register");
        return "index";
    }
    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, Cust cust, HttpSession session) throws Exception {  //변수 너무 많은 경우에는 이렇게! 담아서 한번에 보내자.
        try {
            cust.setPwd(encoder.encode(cust.getPwd()));
            custService.register(cust);
            session.setMaxInactiveInterval(100000);
            session.setAttribute("logincust", cust);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("가입불가");
        }
        model.addAttribute("rcust", cust);
        model.addAttribute("center", "registerok");
        return "index";
    }
    @RequestMapping("/websocket")
    public String websocket(Model model){
        model.addAttribute("center", "websocket");
        return "index";
    }
}
