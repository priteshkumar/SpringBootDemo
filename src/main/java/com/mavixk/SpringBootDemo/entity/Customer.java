package com.mavixk.SpringBootDemo.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int customerId;

  //use @Size as it provides bean validation
  //before inserting entity
  @Size(max=20)
  @NotNull
  @Column(name="first_name")
  private String firstName;

  @Size(max=20)
  @Column(name="last_name")
  private String lastName;

  @Size(max=20)
  @NotNull
  @Column(name="password")
  private String password;

  @Size(max=20)
  @NotNull
  @Column(name="user_name",unique = true)
  private String userName;

  @Column(name="dob")
  @NotNull
  private LocalDateTime dateOfBirth;

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public int getCustomerId() {
    return customerId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPassword() {
    return password;
  }

  public String getUserName() {
    return userName;
  }

  public LocalDateTime getDateOfBirth() {
    return dateOfBirth;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setDateOfBirth(LocalDateTime dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
