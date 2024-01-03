package com.example.jkapi.test;

import com.example.jkapi.utils.DB_l;
import com.example.jkapi.utils.DB_local;
import com.example.jkapi.utils.DB_mid;
import com.example.jkapi.utils.DB_woqutech;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class sqltest {
    @Test
    public void getaaa(){
        String sql = "Select * from table1 where id = 1";
        System.out.println(sql);
        List<Map<String,Object>> ls1 = DB_mid.getTemplate().queryForList(sql);

        System.out.println(ls1);
        if (ls1.isEmpty()){
            System.out.println("1");
        }else System.out.println("2");
    }

    @Test
    public void getaaa1(){
        String sql="select * from HRMRESOURCE where id=23";
        System.out.println(sql);
        List<Map<String,Object>> ls1 = DB_woqutech.getTemplate().queryForList(sql);

        System.out.println(ls1);
        if (ls1.isEmpty()){
            System.out.println("1");
        }else System.out.println("2");
    }

    @Test
    public void getlocal(){
        String sql = "select * from EMPLOYEES ";
        System.out.println(sql);
        List<Map<String,Object>> ls1 = DB_local.getTemplate().queryForList(sql);
        System.out.println(ls1);
        if (ls1.isEmpty()){
            System.out.println("1");
        }else System.out.println("2");
    }

    @Test
    public void get1(){
        String a1111 = "111";
        String f = "1".equals(a1111) ? "ZFI_ASSET_ABAON1" : ("11".equals(a1111) ? "ZFI_ASSET_ABAON11" : "ZFI_ASSET_F92111") ;
        System.out.println(f);
    }


}
