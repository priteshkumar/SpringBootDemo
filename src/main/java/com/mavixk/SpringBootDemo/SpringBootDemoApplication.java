package com.mavixk.SpringBootDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootDemoApplication {

  public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(SpringBootDemoApplication.class,
        args);
    //for(String bean:applicationContext.getBeanDefinitionNames())
      //System.out.println(bean);
    System.out.println(applicationContext.containsBean("webPageController"));
  }

  @Component
  class PostSetup implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
      System.out.println("run postsetup tasks");
    }
  }

}
