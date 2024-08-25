package com.movies.moviescatalog.repositories;

import com.movies.moviescatalog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User,Long> {

}
