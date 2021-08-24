package com.mavixk.SpringBootDemo;

import com.mavixk.SpringBootDemo.dao.CustomerDao;
import com.mavixk.SpringBootDemo.dao.TheatreDao;
import com.mavixk.SpringBootDemo.entity.Customer;
import com.mavixk.SpringBootDemo.entity.Theatre;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class MovieApp {

  public static void main(String[] args) {
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

    //use TheatreDao jparepo
    TheatreDao theatreDao = applicationContext.getBean(TheatreDao.class);

    Theatre theatre1 = new Theatre();
    theatre1.setTheatreName("a1");
    theatre1.setTicketPrice(BigDecimal.valueOf(240.2));

    Theatre theatre2 = new Theatre();
    theatre2.setTheatreName("a2");
    theatre2.setTicketPrice(BigDecimal.valueOf(320.12));

    Theatre theatre3 = new Theatre();
    theatre3.setTheatreName("a3");
    theatre3.setTicketPrice(BigDecimal.valueOf(210.40));

    List<Theatre> theatreList = new LinkedList<>();
    theatreList.add(theatre1);
    theatreList.add(theatre2);
    theatreList.add(theatre3);
    List<Theatre> savedTheatres = theatreDao.saveAll(theatreList);
    for (Theatre theatre : savedTheatres) {
      System.out.println(theatre.getTheatreName());
    }

    //findByTheatreName
    theatreDao.findByTheatreNameContaining("a")
        .forEach(theatre -> System.out.println(theatre.getTheatreName()));

    //use Pageable
    Page<Theatre> theatrePage = theatreDao.findAll(PageRequest.of(0,2));
    System.out.println("#####printing theatre page 0");
    theatrePage.forEach(theatre -> System.out.println(theatre.getTheatreName()));

  }

}
