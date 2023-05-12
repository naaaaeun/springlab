package com.kbstar.custTest;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Slf4j
@SpringBootTest
class InsertTest {

    @Autowired
    CustService service;

    @Test
    void contextLoads(){
        Cust obj =new Cust("id20","pwd20","james");
        try{
            service.register(obj);
            log.info("register ok ================================================================================");
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                log.info("id 중복오류================================================================================");
            }else{
                log.info("시스템오류================================================================================");
            }
        }
    }

}
