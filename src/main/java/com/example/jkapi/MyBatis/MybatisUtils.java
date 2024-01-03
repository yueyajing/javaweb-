package com.example.jkapi.MyBatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    //使用mybatis第一步，获取sqlSessionFactory对象
    static {
        try {
            System.out.println("进入");
            String resource = "mybatis-config.xml";
            System.out.println("path");
            InputStream inputStream = Resources.getResourceAsStream(resource);
            System.out.println("资源");
            System.out.println("获取");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了sqlSessionFactory,顾名思义，我们就可以从中获得sqlSession的实例了
    //sqlSession 完全包含了面向数据库执行SQL命令所需的所有方法
    public static SqlSession getSqlSession(){
        System.out.println("此处");
        return sqlSessionFactory.openSession();
    }

}