package com.example.jkapi.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DB_mid {
    public static DataSource dataSourceA = new ComboPooledDataSource("mid_hr");
    public static DataSource dataSourceB = new ComboPooledDataSource("OA");

    public static JdbcTemplate getTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceA);

        return jdbcTemplate;
    }
}
