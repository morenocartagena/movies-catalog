package com.movies.moviescatalog.controllers;


import com.movies.moviescatalog.entities.Rating;
import com.movies.moviescatalog.services.RatingServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingRestController {

private final RatingServices ratingServices;

    //ResourceEndPoint:http://localhost:8085/movies-catalog/rating/add
    @Operation(summary = "Add a rating", description = "Add a rating to a movie")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rating added"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - Rating was not added")
    })
    @PostMapping("/addRating")
    public Rating addRating(@RequestBody Rating r)
    { return  ratingServices.addOrUpdateRating(r);}


    //ResourceEndPoint:http://localhost:8085/movies-catalog/rating/all
    @Operation(summary = "Get all ratings", description = "Retrieves all the movie's ratings")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ratings retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - Ratings were not found")
    })
    @GetMapping("/getAllRatings")
    public List<Rating> getAllRatings ()
    { return ratingServices.retrieveAllRatings();}


    //ResourceEndPoint:http://localhost:8085/movies-catalog/rating/getOneById/{idU}
    @Operation(summary = "Get rating by id", description = "Returns a rating as per the id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rating retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - The rating was not found")
    })
    @GetMapping("/getOneById/{id}")
    public Rating getRatingById(@PathVariable("id") Integer rating_id)
    {return ratingServices.retrieveRating((long) rating_id);}


    //ResourceEndPoint:http://localhost:8085/movies-catalog/rating/deleteById/{id}
    @Operation(summary = "Delete a rating", description = "Delete a rating from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully deleted"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The rating was not deleted")
    })
    @DeleteMapping("/deleteById/{id}")
    public void deleteRating(@PathVariable("id")  Integer rating_id)
    { ratingServices.deleteRating((long) rating_id);}


    //ResourceEndPoint:http://localhost:8085/movies-catalog/rating/updateRating
    @Operation(summary = "Update a rating", description = "Updates a rating")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The rating was not updated")
    })
    @PutMapping("/updateRating")
     public Rating updateRating(@RequestBody  Rating r)
     {return ratingServices.addOrUpdateRating(r);}

    }
