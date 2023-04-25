package com.kbstar.controller;

import com.kbstar.dto.CustDTO;
import com.kbstar.dto.Marker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//일반적인 컨트롤러는 화면을 반환. ajax는 일부만 반환할 것임. 따라서 어노테이션도 다름.
@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date=new Date();
        return date;
    }
    @RequestMapping("/checkid")
    public Object checkid(String id){
        int result =0;
        if(id.equals("aaaa")||id.equals("jjjj")||id.equals("ssss")){
            result=1;
        }
        return result;
    }
    @RequestMapping("/getdata")
    public Object getdata(){
        List<CustDTO> list=new ArrayList<>();
        list.add(new CustDTO("id01","pwd" , "james1"));
        list.add(new CustDTO("id02","pwd" ,"james2"));
        list.add(new CustDTO("id03","pwd" ,"james3"));
        list.add(new CustDTO("id04","pwd" ,"james4"));
        list.add(new CustDTO("id05","pwd" ,"james5"));

        // java object --> json으로 형변환. 이를 위해 pom에 라이브러리 추가함.

        JSONArray ja =new JSONArray();
        for(CustDTO obj:list){
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
    @RequestMapping("/markers")
    public Object markers(String loc){
        List<Marker> list=new ArrayList<>();

        if(loc.equals("s")){
            list.add(new Marker(100,"담미온","http://www.naver.com", 37.5451437,127.0578284,"a.jpg","s"));
            list.add(new Marker(101,"제주국수","http://www.naver.com", 37.5455175,127.0577641,"b.jpg","s"));
            list.add(new Marker(102,"이층집","http://www.naver.com", 37.5448364,127.0568048,"c.jpg","s"));
        }else if(loc.equals("b")){
            list.add(new Marker(103,"담미온","http://www.naver.com", 35.1928469 ,  129.1536114,"a.jpg","b"));
            list.add(new Marker(104,"제주국수","http://www.naver.com", 35.1948469,   129.1536162,"b.jpg","b"));
            list.add(new Marker(105,"이층집","http://www.naver.com", 35.1958469 ,  129.1536172,"c.jpg","b"));
        }else if(loc.equals("j")){
            list.add(new Marker(106,"담미온","http://www.naver.com", 33.5114137,   126.4913544,"a.jpg","j"));
            list.add(new Marker(107,"제주국수","http://www.naver.com", 33.5124138,   126.4913734,"b.jpg","j"));
            list.add(new Marker(108,"이층집","http://www.naver.com", 33.5134139,   126.4913594,"c.jpg","j"));
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

}
