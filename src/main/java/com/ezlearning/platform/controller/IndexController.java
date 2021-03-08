package com.ezlearning.platform.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MVC Index Controller
 */
@Controller
@RequestMapping("/")
public class IndexController {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
  
  @GetMapping({ "/", "/index" })
  public String index() {
    LOGGER.info("Home page");
    return "index";
  }
  
  @GetMapping("/discover")
  public String discover() {
    return "discover";
  }
  
  @GetMapping("/login")
  public String loginPage(Model model) {
    return "login";
  }
  
  @GetMapping("/logout-success")
  public String logoutPage(Model model) {
    return "logout";
  }
}
