package com.cause.basic.intercepter;

import com.cause.basic.model.UserHeader;
import com.cause.basic.threadlocal.UserHeaderHodler;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cause
 * @date 2021/12/10
 *
 * todo 通过这个注解@Component不能创建对象
 * todo redis连接池的原理
 */
//@Component
public class UserHeaderIntercepter implements HandlerInterceptor {

  /**
   * 一次http方法调用都是在一个线程完成的
   * 因为本次请求的很多地方都可能会用到userId
   * 所以放在threadLocal可以减少参数的传递
   *
   * @param request
   * @param response
   * @param handler
   * @return
   * @throws Exception
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    UserHeader userHeader = UserHeader.builder()
            .userId(request.getHeader("userId"))
            .version(request.getHeader("version"))
            .build();
    UserHeaderHodler.threadLocal.set(userHeader);
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }

  /**
   * 本次调用结束了，就可以释放threadLocal资源避免内存泄漏的情况发生
   * @param request
   * @param response
   * @param handler
   * @param ex
   * @throws Exception
   */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    UserHeaderHodler.threadLocal.remove();
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
}
