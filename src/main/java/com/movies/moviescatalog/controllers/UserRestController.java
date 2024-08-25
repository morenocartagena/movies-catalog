package com.movies.moviescatalog.controllers;


import com.movies.moviescatalog.entities.User;
import com.movies.moviescatalog.services.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {

private final UserServices userServices;


    //RessourceEndPoint:http://localhost:8085/movies-catalog/user/add
    @Operation(summary = "Add an user", description = "Create a new user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully added"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The user was not created")
    })
    @PostMapping("/addUser")
    public User addUser(@RequestBody User u)
    { return  userServices.addOrUpdateUser(u);}


    //RessourceEndPoint:http://localhost:8085/movies-catalog/user/all
    @Operation(summary = "Retrieve users", description = "Retrieves all the users")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - The users were not found")
    })
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers ()
    { return userServices.retrieveAllUsers();}


    //RessourceEndPoint:http://localhost:8085/movies-catalog/user/getOneById/{idU}
    @Operation(summary = "Get user by id", description = "Returns an user as per the id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - The user was not found")
    })
    @GetMapping("/getOneById/{id}")
    public User getUserById(@PathVariable("id") Integer user_id)
    {return userServices.retrieveUser((long) user_id);}


    //RessourceEndPoint:http://localhost:8085/movies-catalog/user/deleteById/{id}
    @Operation(summary = "Delete an user", description = "Delete an user from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully deleted"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The user was not deleted")
    })
    @DeleteMapping("/deleteById/{id}")
    public void deleteUser(@PathVariable("id")  Integer user_id)
    { userServices.deleteUser((long) user_id);}


    //RessourceEndPoint:http://localhost:8085/movies-catalog/user/updateUser
    @Operation(summary = "Update an user", description = "Updates the properties of an user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error - The user was not updated")
    })
    @PutMapping("/updateUser")
     public User updateUser(@RequestBody  User u)
     {return userServices.addOrUpdateUser(u);}


    }
