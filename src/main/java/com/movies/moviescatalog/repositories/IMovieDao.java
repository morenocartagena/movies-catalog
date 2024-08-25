package com.movies.moviescatalog.repositories;

import com.movies.moviescatalog.entities.Movie;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
//import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
//import org.springframework.data.rest.core.annotation.RestResource;

//public interface IMovieDao extends JpaRepository<Movie, Long> {
public interface IMovieDao extends PagingAndSortingRepository<Movie, Long> {

    //List<Movie> findByName(String name);
    //List<Movie> findByNameContainingIgnoreCase(String name);
    
    //@RestResource
    Page<Movie> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndSynopsisContainingIgnoreCaseAndReleaseyear(
            String name, String category, String synopsis, Integer releaseyear, Pageable pageable);

    //@RestResource
    Page<Movie> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndSynopsisContainingIgnoreCase(
            String name, String category, String synopsis, Pageable pageable);

}
