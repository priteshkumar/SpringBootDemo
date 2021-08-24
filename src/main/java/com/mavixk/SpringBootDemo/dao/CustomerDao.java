package com.mavixk.SpringBootDemo.dao;

import com.mavixk.SpringBootDemo.entity.Customer;

public interface CustomerDao {

  public Customer save(Customer customer);

  public Customer findById(int id);

  public Customer update(Customer customer);

  public void delete(Customer customer);
}
