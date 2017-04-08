package com.fexco.postcode;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
public class AppConfiguration {


}
