/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.configure;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author HP B&O
 */
@Configuration
@ComponentScan(basePackages = "com.cibt.crm ")
@EnableWebMvc
@EnableScheduling
@PropertySource(value = "classpath:application.properties")
public class AppConfiguration implements WebMvcConfigurer {

    @Value(value = "${spring.mvc.view.prefix}")
    private String viewPrefix;
    @Value(value = "${spring.mvc.view.suffix}")
    private String viewSuffix;
    @Value(value = "${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value(value = "${spring.datasource.url}")
    private String dbURL;
    @Value(value = "${spring.datasource.username}")
    private String dbUserName;
    @Value(value = "${spring.datasource.password}")
    private String dbPassword;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
    }

    @Bean
    public ViewResolver getViewResolver() {
        return new InternalResourceViewResolver(viewPrefix, viewSuffix);
    }

    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(driverClassName);
        source.setUrl(dbURL);
        source.setUsername(dbUserName);
        source.setPassword(dbPassword);
        return source;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

//    @Scheduled(fixedDelay = 1000)
    @Scheduled(cron = "* 0 * * * *")
    public void autoUpdate() {
        System.out.println("Hello World" + new Date());
    }
}
