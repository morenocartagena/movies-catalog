package com.movies.moviescatalog.controllers;

import com.movies.moviescatalog.dto.MovieDto;
import com.movies.moviescatalog.entities.Movie;
//import com.movies.moviescatalog.entities.Equipe;
import com.movies.moviescatalog.services.MovieServices;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieRestController {

    @Autowired
    private final MovieServices movieServices;

    //ResourceEndPoint:http://localhost:8085/movies-catalog/movie/add
    @Operation(summary = "Add a movie", description = "Create a new movie")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully added"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The movie was not created")
    })
    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie m) {
        return movieServices.addOrUpdateMovie(m);
    }

    //ResourceEndPoint:http://localhost:8085/movies-catalog/movie/all
    @Operation(summary = "Get all the movies", description = "Retrieves all movies")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - The movies were not found")
    })
    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies() {
        return movieServices.retrieveAllMovies();
    }

    //ResourceEndPoint:http://localhost:8085/movies-catalog/movie/getOneById/{idD}
    @Operation(summary = "Get movie by id", description = "Returns a movie as per the id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - The movie was not found")
    })
    @GetMapping("/getOneById/{id}")
    public Movie getMovieById(@PathVariable("id") Integer movie_id) {
        return movieServices.retrieveMovie((long) movie_id);
    }

    //ResourceEndPoint:http://localhost:8085/movies-catalog/movie/deleteById/{id}
    @Operation(summary = "Delete a movie", description = "Delete a movie from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully deleted"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The movie was not deleted")
    })
    @DeleteMapping("/deleteById/{id}")
    public void deleteMovie(@PathVariable("id") Integer movie_id) {
        movieServices.deleteMovie((long) movie_id);
    }

    //ResourceEndPoint:http://localhost:8085/movies-catalog/movie/updateMovie
    @Operation(summary = "Update a movie", description = "Updates the data of a movie")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The movie was not updated")
    })
    @PutMapping("/updateMovie")
    public Movie updateMovie(@RequestBody MovieDto m) {
        return movieServices.addOrUpdateMovie(m);
    }

    /*//ResourceEndPoint:http://localhost:8085/movies-catalog/movie/retrieveMoviesByName
    @Operation(summary = "Search by name", description = "Get movies by name")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - Movies not found")
    })
    @GetMapping("/retrieveMoviesByName")
    public List<Movie> retrieveMoviesByName(@RequestParam String name) {
        return movieServices.searchMoviesByName(name);
    }*/
    
    //ResourceEndPoint:http://localhost:8085/movies-catalog/movie/search
    //http://localhost:8085/movie/search?name=a&category=a&synopsis=a&releaseyear=2024&page=0&size=1&sortBy=name
    @Operation(summary = "Search movies", description = "Endpoint to search movies. "
            + "Searchable by name or synopsis content."
            + "Filterable by category or year of release. Pageable, deafault page size is 3."
            + "Orderable by year, name, created date or rating")  
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Movies successfully retrieved"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - Movies not found")
    })
    @GetMapping("/search")
    public Page<Movie> searchMovies(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String category,
                                    @RequestParam(required = false) String synopsis,
                                    @RequestParam(required = false) Integer releaseyear,
                                    @RequestParam(defaultValue = "0") Integer page,
                                    @RequestParam(defaultValue = "3") Integer size,
                                    @RequestParam(defaultValue = "name") String sortBy) {
        return movieServices.searchMovies(name, category != null ? category : "", synopsis != null ? synopsis : "", releaseyear, page, size, sortBy);
    }

}
