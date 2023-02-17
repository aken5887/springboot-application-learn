package com.study.springbootlearn;


import com.study.config.annotation.EnableMyAutoConfiguration;
import com.study.config.annotation.MySpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@EnableMyAutoConfiguration
@MySpringBootApplication
public class _6_MySpringBootLearnApplication {

  private static Logger logger = LoggerFactory.getLogger(_6_MySpringBootLearnApplication.class);

  @Value("${server.port}")
  int port;

  @Bean
  ApplicationRunner applicationRunner(Environment env){
    return args -> {
      System.out.println(env.getProperty("server.port"));
      System.out.println(env.getProperty("server.contextPath"));
    };
  }
  public static void main(String[] args) {
    SpringApplication.run(_6_MySpringBootLearnApplication.class, args);
  }
}