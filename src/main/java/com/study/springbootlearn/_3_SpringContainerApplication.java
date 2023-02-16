package com.study.springbootlearn;

import com.study.springbootlearn.controller.GreetingController;
import com.study.springbootlearn.service.GreetingService;
import com.study.springbootlearn.service.GreetingServiceImpl;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class _3_SpringContainerApplication {

  @Bean
  GreetingController greetingController(GreetingService greetingService){
    return new GreetingController(greetingService);
  }

  @Bean
  GreetingService greetingService(){
    return new GreetingServiceImpl();
  }

  public static void main(String[] args) {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext(){
      @Override
      protected void onRefresh() {
        super.onRefresh();
        registerServletContainer(this);
      }
    };
    context.register(_3_SpringContainerApplication.class);
    context.refresh();
  }

  public static void genericApplicationContext(){
    // Spring Container
    GenericWebApplicationContext applicationContext = new GenericWebApplicationContext(){
      @Override
      protected void onRefresh() {
        super.onRefresh();
        registerServletContainer(this);
      }
    };
    applicationContext.registerBean(GreetingController.class);
    applicationContext.registerBean(GreetingServiceImpl.class);
    applicationContext.refresh();
  }

  private static void registerServletContainer(WebApplicationContext context){
    /** Servlet Container */
    ServletWebServerFactory factory = new TomcatServletWebServerFactory();
    WebServer webServer
        = factory.getWebServer(servletContext -> {
      servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context))
          .addMapping("/*");
    });
    webServer.start();
  }
}
