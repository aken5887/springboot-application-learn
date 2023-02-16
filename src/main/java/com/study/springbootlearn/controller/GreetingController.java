package com.study.springbootlearn.controller;

import com.study.springbootlearn.service.GreetingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class GreetingController {

  private final GreetingService greetingService;

  public GreetingController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @ResponseBody
  @GetMapping
  public String hello(String name){
    return greetingService.sayHello(name);
  }
}
