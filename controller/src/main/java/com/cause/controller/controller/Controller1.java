package com.cause.controller.controller;

import com.cause.controller.service.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cause
 * @date 2021/12/10
 */
@RestController
public class Controller1 {

  @Autowired
  Service1 service1;

  @GetMapping("/m1")
  public String m1() {
    return service1.m1();
  }

}
