package com.movies.moviescatalog.services;

import com.movies.moviescatalog.dto.MovieDto;
import com.movies.moviescatalog.entities.Movie;
import com.movies.moviescatalog.entities.User;
//import com.movies.moviescatalog.entities.Universite;
import com.movies.moviescatalog.repositories.IMovieDao;
import com.movies.moviescatalog.repositories.IUserDao;
//import com.movies.moviescatalog.repositories.IUniversiteDao;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServices implements IMovieServices {

    @Autowired
    private IMovieDao iMovieDao;
    @Autowired
    private IUserDao iUserDao;
    
    @Override
    public List<Movie> retrieveAllMovies() {
        return (List<Movie>) iMovieDao.findAll();
    }

    @Override
    public Movie addOrUpdateMovie(Movie m) {
        /*if(m.getMovie_id() == null){
            Long randomPositiveLong = Math.abs(UUID.randomUUID().getLeastSignificantBits());
            m.setMovie_id(randomPositiveLong);
        }*/
        return iMovieDao.save(m);
    }

    public Movie addOrUpdateMovie(MovieDto m) {
        Movie mov = new Movie();
        mov.setMovie_id(m.getMovie_id());
        mov.setName(m.getName());
        mov.setCategory(m.getCategory());
        mov.setCreated_date(m.getCreated_date());
        mov.setPoster_url(m.getPoster_url());
        mov.setSynopsis(m.getSynopsis());
        mov.setRating(m.getRating());

        User u = iUserDao.findById(m.getUser_id()).orElse(null);
        mov.setUser(u);

        return addOrUpdateMovie(mov);
    }

    @Override
    public Movie retrieveMovie(Long movie_id) {
        return iMovieDao.findById(movie_id).orElse(null);
    }

    @Override
    public void deleteMovie(Long movie_id) {
        iMovieDao.deleteById(movie_id);
    }

    /*@Override
    public List<Movie> searchMoviesByName(String name) {
        //Movie movies = iMovieDao.findById(100L).orElse(null);
        return iMovieDao.findByNameContainingIgnoreCase(name);
        //return iMovieDao.findByName(name);
    }*/

    @Override
    public Page<Movie> searchMovies(String name, String category, String synopsis, Integer releaseyear, Integer page, Integer size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        if (releaseyear != null) {
            return iMovieDao.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndSynopsisContainingIgnoreCaseAndReleaseyear(
                name, category, synopsis, releaseyear, pageable);
        } else {
            return iMovieDao.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndSynopsisContainingIgnoreCase(
                name, category, synopsis, pageable);
        }
    }

}
