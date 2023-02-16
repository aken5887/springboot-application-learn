package com.study.springbootlearn.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{
  @Override
  public String sayHello(String name) {
    return "Hello,"+name;
  }
}
