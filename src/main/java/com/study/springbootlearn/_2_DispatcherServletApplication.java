package com.study.springbootlearn;

import com.study.springbootlearn.controller.GreetingController;
import com.study.springbootlearn.service.GreetingServiceImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;

public class _2_DispatcherServletApplication {
  public static void main(String[] args) {
    // Spring Container
    GenericApplicationContext context  = new GenericApplicationContext();
    context.registerBean(GreetingController.class);
    context.registerBean(GreetingServiceImpl.class);
    context.refresh();

    ServletWebServerFactory factory = new TomcatServletWebServerFactory();
    WebServer webServer = factory.getWebServer(servlet -> {
      servlet.addServlet("dispatcherServlet", new HttpServlet() {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          if(req.getRequestURI().startsWith("/hello") && req.getMethod().equals("GET")){
            String name = req.getParameter("name");
            GreetingController controller = context.getBean(GreetingController.class);
            String ret = controller.hello(name);
            resp.getWriter().println(ret);
          }
        }
      }).addMapping("/*");
    });
    webServer.start();
  }
}
