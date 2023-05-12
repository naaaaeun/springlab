package com.kbstar.controller;

import com.kbstar.dto.Ncp;
import com.kbstar.util.*;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class NcpController {
    @Value("${uploadimgdir}")
    String imgpath;

    @RequestMapping("/cfr1impl")
    public String cfr1impl(Model model, Ncp ncp) throws ParseException {
        //이미지 저장한다.
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);
        //ncp에 요청한다.

        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result= (JSONObject)CFRCelebrityUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());
        //결과를 받는다.
        JSONArray faces = (JSONArray)result.get("faces");
        JSONObject obj = (JSONObject) faces. get(0);
        JSONObject celebrity = (JSONObject)obj.get("celebrity");
        String value = (String)celebrity.get("value");
        log.info(value);



        model.addAttribute("result",value);
        model.addAttribute("center","cfr1");
        return "index";
    }
    @RequestMapping("/cfr2impl")
    public String cfr2impl(Model model, Ncp ncp) throws ParseException {
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result= (JSONObject)CFRFaceUtil.getResult(imgpath, imgname);

        String emotion_value = "";
        String gender_value = "";
        String pose_value = "";
        String age_value = "";

        JSONArray faces = (JSONArray)result.get("faces");
        JSONObject obj = (JSONObject)faces.get(0);

        JSONObject emotion = (JSONObject) obj.get("emotion");
        emotion_value = (String)emotion.get("value");

        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String)gender.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String)pose.get("value");

        JSONObject age = (JSONObject) obj.get("age");
        age_value = (String)age.get("value");


        Map<String, String> map=new HashMap<>();

        map.put("emotion",emotion_value);
        map.put("pose",pose_value);
        map.put("age",age_value);
        map.put("gender",gender_value);


        model.addAttribute("result",map);
        model.addAttribute("center","cfr2");
        return "index";
    }
    @RequestMapping("/mycfr")
    public String mycfr(Model model, String imgname) throws ParseException {

        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());

        String emotion_value = "";
        String gender_value = "";
        String pose_value = "";
        String age_value = "";

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);

        JSONObject emotion = (JSONObject) obj.get("emotion");
        emotion_value = (String) emotion.get("value");

        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String) gender.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String) pose.get("value");

        JSONObject age = (JSONObject) obj.get("age");
        age_value = (String) age.get("value");

        Map<String, String> map = new HashMap<>();
        map.put("emotion", emotion_value);
        map.put("pose", pose_value);
        map.put("age", age_value);
        map.put("gender", gender_value);

        // 결과를 받는다
        model.addAttribute("result", map);
        model.addAttribute("center", "pic");
        return "index";
    }
    @RequestMapping("/ocr1impl")
    public String ocr1impl(Model model, Ncp ncp) throws ParseException {
        //이미지 저장한다.
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);
        //ncp에 요청한다.
        String imgname = ncp.getImg().getOriginalFilename();

        JSONObject result= (JSONObject) OCRUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());
        //결과를 받는다.
        Map map = OCRUtil.getData(result);



        model.addAttribute("result",map);
        model.addAttribute("center","ocr1");
        return "index";
    }
    @RequestMapping("/ocr2impl")
    public String ocr2impl(Model model, Ncp ncp) throws ParseException {
        //이미지 저장한다.
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);
        //ncp에 요청한다.
        String imgname = ncp.getImg().getOriginalFilename();

        JSONObject result= (JSONObject) OCRJiroUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());
        //결과를 받는다.
        Map map = OCRJiroUtil.getData(result);



        model.addAttribute("result",map);
        model.addAttribute("center","ocr2");
        return "index";
    }
}
