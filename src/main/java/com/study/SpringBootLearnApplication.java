package com.study;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

//@SpringBootApplication confict -> HandlerMapping bean initiated, no servlet context
public class SpringBootLearnApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootLearnApplication.class, args);
  }
}
