package com.movies.moviescatalog.services;

import com.movies.moviescatalog.entities.User;

import java.util.List;

public interface IUserServices {

    List<User> retrieveAllUsers();

    User addOrUpdateUser(User u);

    User retrieveUser (Long user_id);

    void deleteUser (Long user_id);

    //public List<User> searchUsersByName(String name);
    
    //public List<User> searchUsersBySynopsis(String synopsis);

}
