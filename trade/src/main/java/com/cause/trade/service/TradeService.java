package com.cause.trade.service;

import com.cause.basic.threadlocal.UserHeaderHodler;
import org.springframework.stereotype.Service;

/**
 * @author cause
 * @date 2021/12/10
 */
@Service
public class TradeService {

  /**
   * 拦截器和service方法同处于一个线程，所以可以通过这种方式，保证userHeader的线程安全
   * 同时避免参数多次传递
   * @return
   */
  public String m1() {
    return UserHeaderHodler.getUserId() + "====>" + UserHeaderHodler.getVersion();
  }

}
