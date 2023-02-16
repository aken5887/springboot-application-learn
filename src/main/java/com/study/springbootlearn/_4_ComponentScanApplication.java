package com.study.springbootlearn;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@ComponentScan("com.study")
@Configuration
public class _4_ComponentScanApplication {
  public static void main(String[] args) {
    // 1. 스프링 컨테이너 정의
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext(){
      @Override
      protected void onRefresh() {
        super.onRefresh();
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        WebServer webServer = factory.getWebServer(servletContext -> {
          servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this))
              .addMapping("/*");
        });
        webServer.start();
      }
    };
    context.register(_4_ComponentScanApplication.class);
    context.refresh();
  }
}
