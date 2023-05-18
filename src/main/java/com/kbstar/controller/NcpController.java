package com.kbstar.controller;

import com.kbstar.dto.Ncp;
import com.kbstar.util.CFRCelebrityUtil;
import com.kbstar.util.CFRFaceUtil;
import com.kbstar.util.FileUploadUtil;
import com.kbstar.util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
    public String cfr1impl(Model model, Ncp ncp) {

        FileUploadUtil.saveFile(ncp.getImg(), imgpath);

        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) CFRCelebrityUtil.getText(imgpath, imgname);

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject object = (JSONObject) faces.get(0);
        JSONObject celebrity = (JSONObject) object.get("celebrity");
        String value = (String) celebrity.get("value");

        log.info("cfr1value={}", value);

        model.addAttribute("result", value);
        model.addAttribute("center", "cfr1");

        return "index";
    }


    @RequestMapping("/cfr2impl")
    public String cfr2impl(Model model, Ncp ncp) {

        FileUploadUtil.saveFile(ncp.getImg(), imgpath);

        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath, imgname);

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject object = (JSONObject) faces.get(0);
        JSONObject gender = (JSONObject) object.get("gender");
        String value = (String) gender.get("value");
        double value1 = (double) gender.get("confidence");

        log.info("cfr2value={}", value);

        Map<String, Object> map = new HashMap<>();
        map.put("gender", value);
        map.put("confidence", value1);

        model.addAttribute("result", map);
        model.addAttribute("center", "cfr2");

        return "index";
    }

    @RequestMapping("/mycfr")
    public String mycfr(Model model, String imgname) {

        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath, imgname);

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject object = (JSONObject) faces.get(0);
        JSONObject gender = (JSONObject) object.get("gender");
        String value = (String) gender.get("value");
        double value1 = (double) gender.get("confidence");

        log.info("cfr2value={}", value);

        Map<String, Object> map = new HashMap<>();
        map.put("gender", value);
        map.put("confidence", value1);

        model.addAttribute("result", map);
        model.addAttribute("center", "pic");

        return "index";
    }

    @RequestMapping("/ocr1impl")
    public String ocr1impl(Model model, Ncp ncp) {
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) OCRUtil.getText(imgpath, imgname);

        log.info("OCRUtil.getText(imgpath, imgname)={}",OCRUtil.getText(imgpath, imgname));


        Map map = OCRUtil.getData(result);

        model.addAttribute("result", map);
        model.addAttribute("center", "ocr1");

        return "index";
    }

}
