package com.cause.trade.controller;

import com.cause.basic.base.resp.RestResponse;
import com.cause.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cause
 * @date 2021/12/10
 */
@RestController
public class TradeController {

  @Autowired
  TradeService tradeService;

  @GetMapping("/m1")
  public RestResponse<String> m1() {
    return RestResponse.ok("");
  }

}
