package com.cause.basic.config;

import com.cause.basic.intercepter.UserHeaderIntercepter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cause
 * @date 2021/12/10
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Bean
  public UserHeaderIntercepter userHeaderIntercepter() {
    return new UserHeaderIntercepter();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(userHeaderIntercepter());
    WebMvcConfigurer.super.addInterceptors(registry);
  }
}
