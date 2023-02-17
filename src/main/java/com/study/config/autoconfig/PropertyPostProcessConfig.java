package com.study.config.autoconfig;

import com.study.config.annotation.MyConfigurationProperties;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

public class PropertyPostProcessConfig {

  @Bean
  BeanPostProcessor beanPostProcessor(Environment env){
    return new BeanPostProcessor() {
      @Override
      public Object postProcessAfterInitialization(Object bean, String beanName)
          throws BeansException {

        MyConfigurationProperties annotation
            = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);

        if(annotation == null) return bean;

        Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(annotation);
        String prefix = (String) attrs.get("prefix");
        Object ret = Binder.get(env).bindOrCreate(prefix, bean.getClass());
        return ret;
      }
    };
  }
}
