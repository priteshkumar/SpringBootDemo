package com.mavixk.SpringBootDemo.dao;

import com.mavixk.SpringBootDemo.entity.Theatre;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreDao extends JpaRepository<Theatre, Integer> {

  Theatre findByTheatreName(String theatre_name);

  List<Theatre> findByTicketPriceLessThan(BigDecimal ticketPrice);

  List<Theatre> findByTheatreNameContaining(String sub);
}
