package com.movies.moviescatalog.services;

import com.movies.moviescatalog.entities.Movie;

import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;

import java.util.List;

public interface IMovieServices {

    List<Movie> retrieveAllMovies();

    Movie addOrUpdateMovie(Movie m);

    Movie retrieveMovie (Long movie_id);

    void deleteMovie (Long movie_id);

    //List<Movie> searchMoviesByName(String name);
    
    Page<Movie> searchMovies(String name, String category, String synopsis, Integer releaseyear, Integer page, Integer size, String sortBy);

}
