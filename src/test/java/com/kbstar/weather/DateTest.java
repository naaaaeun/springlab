package com.kbstar.weather;

import com.kbstar.service.AdmService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@SpringBootTest
class DateTest {
    @Autowired
    AdmService service;

    @Test
    void contextLoads() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);

        String today = "" + year + month + day;
        if (month <= 10) {
            today = "" + year + "0" + month + day;
        }

        log.info(today);

        try {
        } catch (Exception e) {
            log.info("에러..");
        }
    }

}
