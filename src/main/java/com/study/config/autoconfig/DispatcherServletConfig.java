package com.study.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

public class DispatcherServletConfig {
  @Bean
  @ConditionalOnMissingBean
  public DispatcherServlet dispatcherServlet(){
    return new DispatcherServlet();
  }
}
