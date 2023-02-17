package com.study.config.autoconfig;

import com.study.config.annotation.EnableMyConfigurationProperties;
import com.study.config.annotation.MyOnClassCondition;
import com.study.config.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@EnableMyConfigurationProperties(ServerProperties.class)
@MyOnClassCondition("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

  private final Logger logger = LoggerFactory.getLogger(TomcatWebServerConfig.class);

  @Bean
  @ConditionalOnMissingBean
  public ServletWebServerFactory servletWebServerFactory(ServerProperties serverProperties){
    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
    factory.setPort(serverProperties.getPort());
    factory.setContextPath(serverProperties.getContextPath());
    return factory;
  }
}
