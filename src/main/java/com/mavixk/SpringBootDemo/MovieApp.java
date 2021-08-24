package com.mavixk.SpringBootDemo;

import com.mavixk.SpringBootDemo.dao.CustomerDao;
import com.mavixk.SpringBootDemo.entity.Customer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieApp {

  public static void main(String[] args){
    ApplicationContext applicationContext = SpringApplication.run(MovieApp.class,args);
    CustomerDao customerDao = applicationContext.getBean(CustomerDao.class);

    Customer customer = new Customer();
    customer.setFirstName("rusty");
    customer.setLastName("russell");
    customer.setDateOfBirth(LocalDateTime.of(1986,02,27,9,32));
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
  }

}
