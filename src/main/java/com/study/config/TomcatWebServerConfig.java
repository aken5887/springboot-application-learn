package com.study.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

public class TomcatWebServerConfig {
  @Bean
  public ServletWebServerFactory servletWebServerFactory(){
    return new TomcatServletWebServerFactory();
  }
}