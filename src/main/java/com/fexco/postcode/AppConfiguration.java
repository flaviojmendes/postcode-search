package com.fexco.postcode;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
@PropertySource(Constants.Properties)
@Configuration
public class AppConfiguration {




}
