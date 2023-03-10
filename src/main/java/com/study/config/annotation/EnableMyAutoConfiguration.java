package com.study.config.annotation;

import com.study.config.MyAutoConfigImportSelector;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Import({DispatcherServlet.class, TomcatWebServerConfig.class})
@Import(MyAutoConfigImportSelector.class)
public @interface EnableMyAutoConfiguration {
}
