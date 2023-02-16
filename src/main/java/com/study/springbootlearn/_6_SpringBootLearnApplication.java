package com.study.springbootlearn;


import com.study.config.annotation.EnableMyAutoConfiguration;
import com.study.config.annotation.MySpringBootApplication;

@EnableMyAutoConfiguration
@MySpringBootApplication
public class _6_SpringBootLearnApplication {
  public static void main(String[] args) {
    MySpringApplication.run(_6_SpringBootLearnApplication.class, args);
  }
}
