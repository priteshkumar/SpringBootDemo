package com.mavixk.SpringBootDemo.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "movie")
@Check(constraints = "duration > 60")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int movieId;

  @Size(max = 50)
  @NotNull
  @Column(name = "movie_name", unique = true)
  private String movieName;

  @Size(max = 500)
  @NotNull
  @Column(name = "movie_desc")
  private String movieDesc;

  @NotNull
  private LocalDate releaseDate;

  @NotNull
  private Duration duration;

  @Size(max = 500)
  @NotNull
  private String coverphotoUrl;

  @Size(max = 500)
  @NotNull
  private String trailerUrl;

  public int getMovieId() {
    return movieId;
  }

  public void setMovieId(int movieId) {
    this.movieId = movieId;
  }

  public String getMovieName() {
    return movieName;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  public String getMovieDesc() {
    return movieDesc;
  }

  public void setMovieDesc(String movieDesc) {
    this.movieDesc = movieDesc;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getCoverphotoUrl() {
    return coverphotoUrl;
  }

  public void setCoverphotoUrl(String coverphotoUrl) {
    this.coverphotoUrl = coverphotoUrl;
  }

  public String getTrailerUrl() {
    return trailerUrl;
  }

  public void setTrailerUrl(String trailerUrl) {
    this.trailerUrl = trailerUrl;
  }

  public Duration getDuration() {
    return duration;
  }

  public void setDuration(Duration duration) {
    this.duration = duration;
  }
}
