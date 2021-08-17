package com.mavixk.SpringBootDemo.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//setting up bean activation in dev/default profiles
@Profile({"dev","default"})
public class HomeController {

  @RequestMapping("/mypage")
  public String getHomePage(Model model) {
    System.out.println("get home page");
    return "mavixk";
  }

}
