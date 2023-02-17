package com.study.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class PropertySourcesPlaceholderConfig {
  @Bean
  public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
    return new PropertySourcesPlaceholderConfigurer();
  }
}
