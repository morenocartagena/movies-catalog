package com.movies.moviescatalog.services;

import com.movies.moviescatalog.entities.User;
//import com.movies.moviescatalog.entities.Universite;
import com.movies.moviescatalog.repositories.IUserDao;
//import com.movies.moviescatalog.repositories.IUniversiteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices implements IUserServices {

    private final IUserDao iUserDao;

    @Override
    public List<User> retrieveAllUsers() {
        return iUserDao.findAll();
    }

    @Override
    public User addOrUpdateUser(User u) {
        return iUserDao.save(u);
    }

    @Override
    public User retrieveUser(Long user_id) {
        return iUserDao.findById(user_id).orElse(null);
    }

    @Override
    public void deleteUser(Long user_id) {
        iUserDao.deleteById(user_id);
    }

}
