package com.study.springbootlearn;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

public class _1_BasicApplication {
  public static void main(String[] args) {
    ServletWebServerFactory factory = new TomcatServletWebServerFactory();
    WebServer webserver = factory.getWebServer(new ServletContextInitializer() {
      @Override
      public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addServlet("hello", new HttpServlet() {
          @Override
          protected void service(
              HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
            PrintWriter writer = resp.getWriter();
            writer.println("hello springboot");
          }
        }).addMapping("/hello");
      }
    });
    webserver.start();
  }
}
