package com.study.config;

import com.study.config.annotation.MyAutoConfiguration;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

  private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
  private final ClassLoader classLoader;

  public MyAutoConfigImportSelector(ClassLoader classLoader){
    this.classLoader = classLoader;
  }

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    List<String> autoConfigs = new ArrayList<>();
    ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(config -> {
      logger.info("loaded Config => {}", config);
      autoConfigs.add(config);
    });
    return autoConfigs.toArray(new String[0]);
  }
}
