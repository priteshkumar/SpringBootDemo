package com.mavixk.SpringBootDemo.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "city")
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int cityId;

  @Size(max = 20)
  @NotNull
  @Column(name="city_name")
  private String cityName;

  //inverse side of bidirectional many-to-one
  @OneToMany(mappedBy = "city",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch =
      FetchType.EAGER)
  private Set<Theatre> theatres;

  public Set<Theatre> getTheatres() {
    return theatres;
  }

  public void setTheatres(Set<Theatre> theatres) {
    this.theatres = theatres;
  }

  public int getCityId() {
    return cityId;
  }

  public void setCityId(int cityId) {
    this.cityId = cityId;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

}
