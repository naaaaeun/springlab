package com.kbstar.controller;

import com.kbstar.mapper.CartMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartMapper cartMapper;

    @RequestMapping("/sum")
    public void main(Model model){
        log.info(String.valueOf(cartMapper.cartsum()));
    }
}
