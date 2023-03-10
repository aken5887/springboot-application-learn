package com.study.config;

import com.study.config.annotation.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "server")
public class ServerProperties {

  String contextPath;
  int port;

  public String getContextPath() {
    return contextPath;
  }

  public void setContextPath(String contextPath) {
    this.contextPath = contextPath;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
