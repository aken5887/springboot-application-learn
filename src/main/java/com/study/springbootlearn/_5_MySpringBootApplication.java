package com.study.springbootlearn;

import com.study.config.annotation.MySpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@MySpringBootApplication
public class _5_MySpringBootApplication {

//  @Bean
//  DispatcherServlet dispatcherServlet(){
//    return new DispatcherServlet();
//  }
//
//  @Bean
//  ServletWebServerFactory webServerFactory(){
//    return new TomcatServletWebServerFactory();
//  }

  public static void main(String[] args) {
    MySpringApplication.run(_5_MySpringBootApplication.class, args);
  }
}
