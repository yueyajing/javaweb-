package com.example.jkapi.mvc_con;

import com.example.jkapi.utils.DB_mid;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MyController {
    @GetMapping("/table")
    public String getTable(Model model) {
        String sql = "SELECT id, name, sex, birth FROM table1";
        List<Map<String, Object>> User = DB_mid.getTemplate().queryForList(sql);

        model.addAttribute("User", User);
        return "list1";
    }

    @Test
    public void te1(){
        String sql = "SELECT id, name, sex, birth FROM table1";
        List<Map<String, Object>> User = DB_mid.getTemplate().queryForList(sql);
        for (int i = 0;i<User.size();i++){
            System.out.println(User.get(i).toString());
        }
    }

}