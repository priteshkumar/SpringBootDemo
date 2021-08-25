package com.mavixk.SpringBootDemo.service;

import com.mavixk.SpringBootDemo.dao.MovieDao;
import com.mavixk.SpringBootDemo.entity.Movie;
import java.util.List;
import javax.xml.ws.ServiceMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

  private MovieDao movieDao;

  @Autowired
  public MovieServiceImpl(MovieDao movieDao){
    this.movieDao = movieDao;
  }

  @Override
  public Movie acceptMovieDetails(Movie movie) {
    return this.movieDao.save(movie);
  }

  @Override
  public Movie getMovieDetails(int id) {
    return this.movieDao.findById(id).get();
  }

  @Override
  public Movie updateMovieDetails(int id, Movie movie) {

    Movie  m = this.movieDao.findById(id).orElse(null);
    if(m != null){
      m.setCoverphotoUrl(movie.getCoverphotoUrl());
      m.setMovieName(movie.getMovieName());
      m.setMovieDesc(movie.getMovieDesc());
      m.setReleaseDate(movie.getReleaseDate());
      m.setDuration(movie.getDuration());
      m.setTrailerUrl(movie.getTrailerUrl());
      return this.movieDao.save(m);
    }
    return null;
  }

  @Override
  public boolean deleteMovie(int id) {
    this.movieDao.deleteById(id);
    return true;
  }

  @Override
  public List<Movie> getAllMovies() {
    return this.movieDao.findAll();
  }

  @Override
  public Page<Movie> getPaginatedMovieDetails(Pageable pageRequest) {
    return this.movieDao.findAll(pageRequest);
  }
}
