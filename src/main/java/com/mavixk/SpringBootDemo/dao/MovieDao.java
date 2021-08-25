package com.mavixk.SpringBootDemo.dao;

import com.mavixk.SpringBootDemo.entity.Movie;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Integer> {

}
