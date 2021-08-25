package com.mavixk.SpringBootDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Join Table for many-to-many mapping(movie <-> theatre)
//allows primary key,customisation
@Entity
@Table(name="movie_theatre")
public class MovieTheatre {

  @Id
  @GeneratedValue
  private int movietheatreId;

  @ManyToOne
  @NotNull
  @JoinColumn(name="movie_id")
  private Movie movie;

  @ManyToOne
  @NotNull
  @JoinColumn(name="theatre_id")
  private Theatre theatre;

  public int getMovietheatreId() {
    return movietheatreId;
  }

  public void setMovietheatreId(int movietheatreId) {
    this.movietheatreId = movietheatreId;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public Theatre getTheatre() {
    return theatre;
  }

  public void setTheatre(Theatre theatre) {
    this.theatre = theatre;
  }
}
