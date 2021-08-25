package com.mavixk.SpringBootDemo.dao;

import com.mavixk.SpringBootDemo.entity.City;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {

  public List<City> findByCityName(String cityName);
}
