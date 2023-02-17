package com.study.config.annotation;

import com.study.config.OnMyClassCondition;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Conditional;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Conditional(OnMyClassCondition.class)
public @interface MyOnClassCondition {
  String value();
}
