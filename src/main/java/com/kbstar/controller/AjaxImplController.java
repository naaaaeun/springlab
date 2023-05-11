package com.kbstar.controller;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.service.CartService;
import com.kbstar.service.MarkerService;
import com.kbstar.service.CustService;
import com.kbstar.util.FileUploadUtil;
import com.kbstar.util.WeatherUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//일반적인 컨트롤러는 화면을 반환. ajax는 일부만 반환할 것임. 따라서 어노테이션도 다름.
@RestController
public class AjaxImplController {

    @Autowired
    MarkerService service;

    @Autowired
    CustService custService;
    @Autowired
    CartService cartService;
    @Value("${uploadimgdir}")
    String imgdir;

    @RequestMapping("/saveimg")
    public String saveimg(MultipartFile file){
        String filename = file.getOriginalFilename();
        FileUploadUtil.saveFile(file, imgdir);
        return filename;
    }

    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date=new Date();
        return date;
    }
    @RequestMapping("/checkid")
    public Object checkid(String id) throws Exception {
        int result =0;
        Cust cust=custService.get(id);
        if(cust!=null){
            result++;
        }
        return result;
    }
    @RequestMapping("/addcart")
    public Object addcart(Cart cart) throws Exception {
        cartService.register(cart);
        return "";
    }
    @RequestMapping("/getdata")
    public Object getdata(){
        List<Cust> list=new ArrayList<>();
        list.add(new Cust("id01","pwd" , "james1"));
        list.add(new Cust("id02","pwd" ,"james2"));
        list.add(new Cust("id03","pwd" ,"james3"));
        list.add(new Cust("id04","pwd" ,"james4"));
        list.add(new Cust("id05","pwd" ,"james5"));

        // java object --> json으로 형변환. 이를 위해 pom에 라이브러리 추가함.

        JSONArray ja =new JSONArray();
        for(Cust obj:list){
            Random r=new Random();
            int i=r.nextInt(100)+1;
            JSONObject jo =new JSONObject();
            jo.put("id",obj.getId());
            jo.put("pwd",obj.getPwd());
            jo.put("name",obj.getName()+i);
            ja.add(jo);
        }
        return ja;
    }

    @RequestMapping("/chart05")
    public Object chart05(String year){
        JSONArray ja=new JSONArray();
        for(int i=1;i<=12;i++){
            Random r=new Random();
            int num=r.nextInt(100)+1;
            ja.add(num);
        }
        return ja;
    }
    @RequestMapping("/markers")
    public Object markers(String loc) throws Exception {
        List<Marker> list=new ArrayList<>();

        list=service.getLoc(loc);

        JSONArray ja=new JSONArray();
        for(Marker obj:list){
            JSONObject jo=new JSONObject();
            jo.put("id",obj.getId());
            jo.put("title",obj.getTitle());
            jo.put("target",obj.getTarget());
            jo.put("lat",obj.getLat());
            jo.put("lng",obj.getLng());
            jo.put("img",obj.getImg());
            jo.put("loc",obj.getLoc());
            ja.add(jo);
        }

        return ja;
    }








    @RequestMapping("/allmarkers")
    public Object allmarkers() throws Exception {
        List<Marker> list=new ArrayList<>();
        try{
            list=service.get();
        }catch (Exception e){
            e.printStackTrace();
        }

        JSONArray ja=new JSONArray();

        for(Marker obj:list){
            JSONObject jo=new JSONObject();
            jo.put("id",obj.getId());
            jo.put("title",obj.getTitle());
            jo.put("target",obj.getTarget());
            jo.put("lat",obj.getLat());
            jo.put("lng",obj.getLng());
            jo.put("img",obj.getImg());
            jo.put("loc",obj.getLoc());
            ja.add(jo);
        }

        return ja;
    }

    @RequestMapping("/weather2")
    public Object weather2() throws Exception {

        return WeatherUtil.getWeather3("108");
    }
}
