package com.mavixk.SpringBootDemo.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="theatre")
public class Theatre {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int theatreId;

  @Size(max=20)
  @NotNull
  @Column(name="theatre_name",unique = true)
  private String theatreName;

  @Column(name="ticket_price",columnDefinition = "DECIMAL(5,2) default '150.00'")
  @NotNull
  private BigDecimal ticketPrice;

  public int getTheatreId() {
    return theatreId;
  }

  public void setTheatreId(int theatreId) {
    this.theatreId = theatreId;
  }

  public String getTheatreName() {
    return theatreName;
  }

  public void setTheatreName(String theatreName) {
    this.theatreName = theatreName;
  }

  public BigDecimal getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(BigDecimal ticketPrice) {
    this.ticketPrice = ticketPrice;
  }
}
