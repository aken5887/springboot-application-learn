package com.study.config.annotation;

import com.study.config.MyAutoConfigImportSelector;
import com.study.config.TomcatWebServerConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Import({DispatcherServlet.class, TomcatWebServerConfig.class})
@Import(MyAutoConfigImportSelector.class)
public @interface EnableMyAutoConfiguration {
}
