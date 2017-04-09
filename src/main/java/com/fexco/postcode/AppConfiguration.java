package com.fexco.postcode;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * Configurations for the Application.
 *
 * @author flavio
 */

@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
@Configuration
@EnableCaching
public class AppConfiguration extends WebMvcConfigurerAdapter {


    @Bean(name = "restTemplate")
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }


}
