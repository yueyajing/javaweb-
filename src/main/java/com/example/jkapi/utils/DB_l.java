package com.example.jkapi.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DB_l {
    public static DataSource dataSourceA = new ComboPooledDataSource("local");
    public static DataSource dataSourceB = new ComboPooledDataSource("OA");

    public static JdbcTemplate getTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceA);

        return jdbcTemplate;
    }
}
