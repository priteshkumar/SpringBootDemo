package com.mavixk.SpringBootDemo.dao;

import com.mavixk.SpringBootDemo.entity.Customer;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoSessionImpl implements CustomerDao {

  private SessionFactory sessionFactory;

  @Autowired
  public CustomerDaoSessionImpl(EntityManagerFactory entityManagerFactory) {
    this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
  }

  @Override
  public Customer save(Customer customer) {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    session.save(customer);
    transaction.commit();
    session.close();
    return customer;
  }

  @Override
  public Customer findById(int id) {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    Customer customer = session.get(Customer.class, id);
    transaction.commit();
    session.close();
    return customer;
  }

  @Override
  public Customer update(Customer customer) {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    Customer mergedCustomer = (Customer) session.merge(customer);
    transaction.commit();
    session.close();
    return mergedCustomer;
  }

  @Override
  public void delete(Customer customer) {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    Customer mergedCustomer = (Customer) session.merge(customer);
    /*
    this is alternative method to delete entity
    Customer delCustomer = session.get(Customer.class,customer.getCustomerId());
    session.delete(delCustomer);
     */
    session.delete(mergedCustomer);
    transaction.commit();
    session.close();
  }
}
