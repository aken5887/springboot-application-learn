package com.study.springbootlearn;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class GreetingApiTest{

  private final String localUrl = "http://localhost:8080";

  @DisplayName("/hello?name={name}테스트")
  @Test
  void helloTest(){
    TestRestTemplate restTemplate = new TestRestTemplate();
    ResponseEntity<String> response
        =  restTemplate.getForEntity(localUrl+"/hello?name={name}", String.class, "YONG");
    Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    Assertions.assertThat(response.getHeaders().getContentType().toString().startsWith(MediaType.TEXT_PLAIN_VALUE)).isTrue();
    Assertions.assertThat(response.getBody()).contains("YONG");
  }
}
