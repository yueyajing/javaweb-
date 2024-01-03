package com.example.jkapi.mvc_con;

import com.example.jkapi.utils.CodeUtil;
import com.example.jkapi.utils.DB_mid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class log {
    Map<String,String> owner = new HashMap<>();

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/list1")
    public String list1() {
        return "list1";
    }
    @GetMapping("/list2")
    public String list2() {
        return "list1";
    }
    @GetMapping("/list3")
    public String list3() {
        return "list1";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> doLogin(@RequestParam String username, @RequestParam String password,@RequestParam String code, HttpSession session) {
        Map<String, String> result = new HashMap<>();
        ModelAndView mv = new ModelAndView();
        String sessionCode = (String)session.getAttribute("identifyFyCode");
        if(!code.isEmpty()&&code.equalsIgnoreCase(sessionCode)){
            result.put("code", "1");
            result.put("msg", "验证码错误");
        }else{
            Map<String, Object> up = DB_mid.getTemplate().queryForMap("select name,sex from table1 where name = ?",username);
            String username11 = (String) up.get("name");
            System.out.println("111:"+username);
            System.out.println("222:"+up.get("name"));
            System.out.println("333:"+up.get("sex"));
            if (up.get("name").equals(username) && up.get("sex").equals(password)) {
                session.setAttribute("username", username);
                result.put("code", "0");
                result.put("msg", "登录成功");
            } else {
                result.put("code", "1");
                result.put("msg", "用户名或密码错误");
            }
            mv.addObject("username",username);
            mv.setViewName("main.html");
        }

        return result;
    }

    @GetMapping("/main")
    public String index(HttpSession session,Model model) {
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        model.addAttribute("username",username);
        if (username != null) {
            return "main";
        } else {
            return "redirect:/index1";
        }
    }

    @GetMapping("/login1")
    public String login1(HttpSession session,Model model) {
        String user = (String) session.getAttribute("param");
        //System.out.println(username);
        //model.addAttribute("username",username);
        /*if (user != null) {

        } else {
            return "redirect:/index1";
        }*/
        return "login1";
    }

    @RequestMapping(value = "paramGet",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String paramGet(@RequestParam("name")String username,
                           @RequestParam("age")int age,
                           @RequestParam(value = "score",required = false)Float score){
        return username+"今年"+age+"岁"+"，考试得了"+score+"分！";
    }

    @RequestMapping(value = "paramPost",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> paramPost(@RequestParam("name")String username,
                                        @RequestParam("age")int age,
                                        @RequestParam(value = "score",required = false)Float score){
        Map<String,String> map = new HashMap<>();
        String ss = username+"今年"+age+"岁"+"，考试得了"+score+"分！";
        map.put("sss",ss);
        return map;
    }

    @RequestMapping(value = "paramPost1",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> paramPost1(@RequestParam("name")String username,
                                        @RequestParam("age")int age,
                                        @RequestParam(value = "score",required = false)Float score){
        Map<String,String> map = new HashMap<>();
        String ss = username+"今年"+age+"岁"+"，考试得了"+score+"分！";
        owner.put("a1",username);
        owner.put("a2", String.valueOf(age));
        owner.put("a3", String.valueOf(score));
        map.put("sss",ss);
        return map;
    }



    @GetMapping("/logout")
    public String logout(Model model) {
        Map<String, String> aa = new HashMap<>();
        aa.put("a11", "admin");
        aa.put("a22", "123456");
        model.addAttribute("aa", aa);
        return "redirect:/login1";
    }


    @GetMapping("list")
    @ResponseBody
    public ResponseEntity<List<Map<String, Object>>> list(){
        String sql = "select id,name,sex,birth from table1";
        List<Map<String, Object>> user =DB_mid.getTemplate().queryForList(sql);
        return  ResponseEntity.ok(user);
    }
    @GetMapping("show")
    public String User(Model model){
        String sql = "select id,name,sex,birth from table1";
        List<Map<String, Object>> user =DB_mid.getTemplate().queryForList(sql);
        //Model User = Model.addAttribute("User",user);
        return "/main";
    }

    @RequestMapping("/identifyImage")
    public void identifyImage(HttpServletResponse response, HttpSession session){
        //创建随机验证码
        CodeUtil utils = new CodeUtil();
        String identifyCode = utils.getIdentifyCode();
        //session存入验证码
        session.setAttribute("identifyCode", identifyCode);
        //根据验证码创建图片
        BufferedImage identifyImage = utils.getIdentifyImage(identifyCode);
        //回传给前端
        utils.responseIdentifyImg(identifyImage,response);

    }



}

