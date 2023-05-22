package com.kbstar.ncp;

import com.kbstar.util.CFRCelebrityUtil;
import com.kbstar.util.CFRFaceUtil;
import com.kbstar.util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
class SelectTest {

    @Value("${uploadimgdir}")
    String imgpath;
    @Autowired
    CFRCelebrityUtil cfrCelebrityUtil ;
    @Autowired
    CFRFaceUtil cfrFaceUtil ;

    @Test
    void CFRCelebrityUtilTest() {
        try {
            String imgname = "ma.png";
            JSONObject text = (JSONObject) cfrFaceUtil.getResult(imgpath, imgname);
            log.info(String.valueOf(text));
        } catch (Exception e) {
            log.info("에러..");
            //e.printStackTrace();
        }
    }

    @Test
    void CFRFaceUtilTest() {
        try {
            String imgname = "na.png";
            JSONObject text = (JSONObject) cfrFaceUtil.getResult(imgpath, imgname);
            log.info(String.valueOf(text));
        } catch (Exception e) {
            e.printStackTrace();
            log.info("에러..");
            //e.printStackTrace();
        }
    }

    @Test
    void OCRTest() {
        try {
            String imgname = "biz1.png";
            JSONObject text = (JSONObject) OCRUtil.getText(imgpath, imgname);

            JSONArray images = (JSONArray) text.get("images");
            JSONObject object = (JSONObject) images.get(0);
            JSONArray fields = (JSONArray) object.get("fields");

            JSONObject bizNumList = (JSONObject) fields.get(0);
            String biznum = (String) bizNumList.get("inferText");

            JSONObject bizNameList = (JSONObject) fields.get(1);
            String bizname = (String) bizNameList.get("inferText");

            JSONObject bizOwnerList = (JSONObject) fields.get(2);
            String bizowner = (String) bizOwnerList.get("inferText");

            JSONObject bizDateList = (JSONObject) fields.get(3);
            String bizdate = (String) bizDateList.get("inferText");

            JSONObject bizAddress = (JSONObject) fields.get(4);
            String bizaddress = (String) bizAddress.get("inferText");


            log.info(biznum);
            log.info(bizname);
            log.info(bizowner);
            log.info(bizdate);
            log.info(bizaddress);




        } catch (Exception e) {
            log.info("에러..");
            //e.printStackTrace();
        }
    }

}
