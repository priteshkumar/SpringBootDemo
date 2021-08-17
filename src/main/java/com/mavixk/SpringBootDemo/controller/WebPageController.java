package com.mavixk.SpringBootDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebPageController {

  @RequestMapping(value = "/page1")
  public String getPage1() {
    return "This is the first task of this exercise";
  }

  @RequestMapping(value = "/page2")
  public String getPage2() {
    return "This is the second task of this exercise";
  }
}
