package com.example.jkapi.MyBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserDaoTest {
    //第一步：获得sqlSession对象
    SqlSession sqlSession;

    @Test
    public void test() {
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //方式一：getMapper
            List<User1> ls = sqlSession.selectList("findAll");

            for (User1 user : ls) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("1111");
            sqlSession.close();
        }

    }


    @Test
    public void testConetion() throws IOException {
        // 核心配置文件classpath路径
        String resource = "mybatis-config.xml";
        // 加载配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        // 构建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 从SqlSessionFactory对象中获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession.getConnection());
        // 归还连接给数据源
        sqlSession.close();
    }

}


