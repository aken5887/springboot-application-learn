package com.study.config;

import com.study.config.annotation.MyOnClassCondition;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

public class OnMyClassCondition implements Condition {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    Map<String, Object> attributes = metadata.getAnnotationAttributes(MyOnClassCondition.class.getName());
    String value = (String) attributes.get("value");
    boolean isPresent = ClassUtils.isPresent(value, context.getClassLoader());
    logger.debug("class name : {}, value : {}, isPresent : {}", MyOnClassCondition.class.getName(), value, isPresent);
    return isPresent;
  }
}
