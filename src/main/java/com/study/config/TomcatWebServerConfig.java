package com.study.config;

import com.study.config.annotation.MyOnClassCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyOnClassCondition("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
  @Bean
  @ConditionalOnMissingBean
  public ServletWebServerFactory servletWebServerFactory(){
    return new TomcatServletWebServerFactory();
  }
}
