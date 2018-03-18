package com.studio.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ApplicationConfig.class})
@ComponentScan(basePackages = {"com.studio"})
public class AppConfig {
}
