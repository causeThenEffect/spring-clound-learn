package com.cause.basic.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author cause
 * @date 2021/12/10
 */
@Data
@Builder
public class UserHeader {

  private String userId;

  private String version;

}
