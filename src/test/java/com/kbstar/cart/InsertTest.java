package com.kbstar.cart;

import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.Date;

@Slf4j
@SpringBootTest
class   InsertTest {
    @Autowired
    CartService service;
    @Test
        void contextLoads() {
            Cart obj = new Cart("id02",100,3);
            try {
                service.register(obj);
                log.info("등록 정상...");
                service.get();
            } catch (Exception e) {
                log.info("★★★★★★★★★★★★★★★시스템 장애입니다.★★★★★★★★★★★★★★★");
                e.printStackTrace();
        }
    }
}
