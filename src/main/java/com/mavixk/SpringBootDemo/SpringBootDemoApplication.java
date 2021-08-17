package com.mavixk.SpringBootDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    static final String dictionaryUrl = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    @Override
    public void run(String... args) throws Exception {
      System.out.println("run postsetup tasks");
      String wordSearch = dictionaryUrl + "google";
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<String> responseEntity = restTemplate.getForEntity(wordSearch,String.class);
      System.out.println(responseEntity.getStatusCodeValue());
      System.out.println(responseEntity.getBody());
    }
  }

}
