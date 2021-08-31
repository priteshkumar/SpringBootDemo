package com.mavixk.SpringBootDemo;

import com.mavixk.SpringBootDemo.dao.CityDao;
import com.mavixk.SpringBootDemo.dao.CustomerDao;
import com.mavixk.SpringBootDemo.dao.MovieDao;
import com.mavixk.SpringBootDemo.dao.TheatreDao;
import com.mavixk.SpringBootDemo.entity.City;
import com.mavixk.SpringBootDemo.entity.Customer;
import com.mavixk.SpringBootDemo.entity.Theatre;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class MovieApp {

  private static Logger logger = LoggerFactory.getLogger(MovieApp.class);

  public static void main(String[] args) throws UnsupportedEncodingException {
    ApplicationContext applicationContext = SpringApplication.run(MovieApp.class, args);

    CustomerDao customerDao = applicationContext.getBean(CustomerDao.class);

    Customer customer = new Customer();
    customer.setFirstName("rusty");
    customer.setLastName("russell");
    customer.setDateOfBirth(LocalDateTime.of(1986, 02, 27, 9, 32));
    customer.setPassword("codemore");
    customer.setUserName("rusty");

    Customer savedCustomer = customerDao.save(customer);
    System.out.println(savedCustomer.getCustomerId() + " :" + savedCustomer.getUserName());

    Customer customerRec = customerDao.findById(savedCustomer.getCustomerId());
    System.out.println(customerRec.getUserName() + " " + customerRec.getFirstName());

    customer.setUserName("vladimir");
    Customer customerUpdated = customerDao.update(customer);
    System.out.println(customerUpdated.getCustomerId() + " " + customerUpdated.getUserName());

    customerDao.delete(customer);
    customerRec = customerDao.findById(customerRec.getCustomerId());
    System.out.println(customerRec);

    testCityDao(applicationContext);
    testTheatreDao(applicationContext);

    MovieDao movieDao = applicationContext.getBean(MovieDao.class);

    logger.debug("call omdbapi");
    testMovies();
  }

  public static void testMovies() throws UnsupportedEncodingException {

    String omdbUrl = "http://www.omdbapi.com/";
    Map<String, String> res = new HashMap<>();
    res.put("t", "inception");
    RestTemplate restTemplate = new RestTemplate();
    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(omdbUrl)
        .queryParam("apikey", "4d37a725").queryParam("t",
            URLEncoder.encode("the matrix", "UTF-8"));
    System.out.println(uriComponentsBuilder.toUriString());
    logger.debug("use resttemplate exchange method");
    ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(uriComponentsBuilder.toUriString(),
            String.class);
    System.out.println(responseEntity.getStatusCodeValue());
    System.out.println(responseEntity.getBody());
  }

  public static void testCityDao(ApplicationContext applicationContext) {
    CityDao cityDao = applicationContext.getBean(CityDao.class);

    City c1 = new City();
    c1.setCityName("copenhagen");
    City savedCity = cityDao.save(c1);
    System.out.println(savedCity.getCityName());
  }

  public static void testTheatreDao(ApplicationContext applicationContext) {

    //use TheatreDao jparepo/CityDao
    CityDao cityDao = applicationContext.getBean(CityDao.class);
    City c = cityDao.findByCityName("copenhagen").get(0);

    TheatreDao theatreDao = applicationContext.getBean(TheatreDao.class);

    Theatre theatre1 = new Theatre();
    theatre1.setTheatreName("a1");
    theatre1.setTicketPrice(BigDecimal.valueOf(240.2));

    //set city for many-to-one mapping
    theatre1.setCity(c);

    Theatre theatre2 = new Theatre();
    theatre2.setTheatreName("a2");
    theatre2.setTicketPrice(BigDecimal.valueOf(320.12));
    theatre2.setCity(c);

    Theatre theatre3 = new Theatre();
    theatre3.setTheatreName("a3");
    theatre3.setTicketPrice(BigDecimal.valueOf(210.40));
    theatre3.setCity(c);

    List<Theatre> theatreList = new LinkedList<>();
    theatreList.add(theatre1);
    theatreList.add(theatre2);
    theatreList.add(theatre3);
    List<Theatre> savedTheatres = theatreDao.saveAll(theatreList);
    for (Theatre theatre : savedTheatres) {
      System.out.println(theatre.getTheatreName());
    }

    //findByTheatreName/City
    theatreDao.findByTheatreNameContaining("a")
        .forEach(theatre -> System.out
            .println(theatre.getTheatreName() + " " + theatre.getCity().getCityName()));

    //use Pageable
    Page<Theatre> theatrePage = theatreDao.findAll(PageRequest.of(0, 2));
    System.out.println("#####printing theatre page 0");
    theatrePage.forEach(theatre -> System.out.println(theatre.getTheatreName()));

  }

}
