package com.example.jkapi.hello;

import com.dahuatech.hutool.json.JSONObject;
import com.dahuatech.hutool.json.JSONUtil;
import com.example.jkapi.utils.DB_mid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Hello")
public class Helloworld {

    @RequestMapping("/world")
    public String getworld(){

        System.out.println("Hello world!");
        return "0";
    }

    @RequestMapping("/getsu")
    public String getsu(@RequestParam("param") Object param){
        Map map = new HashMap<>();
        map.put("a1","666");
        map.put("a2",param);
        String Json = JSONUtil.toJsonStr(map);
        return Json;

    }

    @RequestMapping("/getdb")
    public JSONObject getdb(@RequestParam("id") String id){
        String sql = "select id,name,sex,birth,num1,rq from table1 where id = "+id;
        Map map = DB_mid.getTemplate().queryForMap(sql);
        System.out.println(map.get("rq"));
        String Json = JSONUtil.toJsonStr(map);


        JSONObject json = JSONUtil.parseObj(map, false, true);
        json.setDateFormat("yyyy-MM-dd HH:mm:ss");
        return json;
    }


    @RequestMapping("/getlist")
    public JSONObject getlist(){
        String sql = "select id,name,workcode,code from table2 where id= 1";
        Map map = DB_mid.getTemplate().queryForMap(sql);
        System.out.println(map.get("rq"));
        String Json = JSONUtil.toJsonStr(map);


        JSONObject json = JSONUtil.parseObj(map, false, true);
        json.setDateFormat("yyyy-MM-dd HH:mm:ss");
        return json;
    }

    @RequestMapping("/getlist1")
    public List getlist1(){
        List<Map<String, Object>> ls = DB_mid.getTemplate().queryForList("select id,name,workcode,code from table2");
        return ls;
    }


    @RequestMapping("/getsu1")
    public Map getsu1(){
        Map map = new HashMap<>();
        map.put("a1","111");
        map.put("a2","222");
        map.put("a3","333");
        map.put("a4","4444");
        map.put("a5","5");

        //String Json = JSONUtil.toJsonStr(map);
        return map;

    }
    @RequestMapping("/add")
    public int add(@RequestParam("param") Object param){


        //String Json = JSONUtil.toJsonStr(map);
        return 0;

    }
}
