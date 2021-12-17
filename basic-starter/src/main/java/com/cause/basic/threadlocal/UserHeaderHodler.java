package com.cause.basic.threadlocal;

import com.cause.basic.model.UserHeader;

import java.util.Optional;

/**
 * @author cause
 * @date 2021/12/10
 */
public class UserHeaderHodler {

  public static ThreadLocal<UserHeader> threadLocal = new ThreadLocal<>();

  /**
   * 需要兼容userHeader为null的情况
   * @return
   */
  public static String getUserId() {
    return Optional.ofNullable(threadLocal.get())
            .map(userHeader -> userHeader.getUserId())
            .orElse("");
  }

  public static String getVersion() {
    return Optional.ofNullable(threadLocal.get())
            .map(userHeader -> userHeader.getVersion())
            .orElse("");
  }

}
