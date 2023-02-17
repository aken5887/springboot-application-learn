package com.study;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ConditionalTest {

  @Test
  void conditionalTest(){
    ApplicationContextRunner contextRunner = new ApplicationContextRunner();
    contextRunner.withUserConfiguration(TrueMyBean.class).run(context -> {
      Assertions.assertThat(context).hasSingleBean(TrueMyBean.class);
      Assertions.assertThat(context).hasSingleBean(MyBean.class);
    });
  }

  @Configuration
  @TestClassBooleanCondition(true)
  static class TrueMyBean {
    @Bean
    MyBean myBean() {return new MyBean();}
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Conditional(OnTestClassCondition.class)
  @interface TestClassBooleanCondition {
       boolean value();
  }

  static class OnTestClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      Map<String, Object> attributes
        = metadata.getAnnotationAttributes(TestClassBooleanCondition.class.getName());
      return (boolean) attributes.get("value");
    }
  }

  static class MyBean {
    public MyBean(){
      System.out.println("====================> myBean이 생성되었습니다." + this);
    }
  }
}
