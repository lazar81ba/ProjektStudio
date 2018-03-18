package com.studio.config;



import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class ApplicationConfig {

    //Simple DataSource is created because of Spring restrictions
    @Bean
    public DataSource primaryDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://database_0:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("");

        return dataSource;
    }
}
