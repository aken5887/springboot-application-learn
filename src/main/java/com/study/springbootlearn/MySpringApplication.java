package com.study.springbootlearn;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
  public static void run(Class<?> springClass, String[] args){
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(){
      @Override
      protected void onRefresh() {
        super.onRefresh();
        ServletWebServerFactory factory = this.getBean(ServletWebServerFactory.class);
        WebServer webserver = factory.getWebServer(servletContext -> {
          servletContext.addServlet("dispatcherServlet", this.getBean(DispatcherServlet.class))
              .addMapping("/*");
        });
        webserver.start();
      }
    };
    applicationContext.register(springClass);
    applicationContext.refresh();
  }
}
