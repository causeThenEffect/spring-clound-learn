package com.cause.basic.config;

import com.cause.basic.intercepter.UserHeaderIntercepter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cause
 * @date 2021/12/10
 * todo WebMvcAutoConfiguration 实现原理了解一下，ConditionalOnMissingBean什么意思
 *
 * 继承了 WebMvcAutoConfiguration
 */
//@Configuration
//@EnableWebMvc
public class WebConfig extends WebMvcAutoConfiguration implements WebMvcConfigurer {

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
