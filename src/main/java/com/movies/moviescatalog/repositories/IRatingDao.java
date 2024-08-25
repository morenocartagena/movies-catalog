package com.movies.moviescatalog.repositories;

import com.movies.moviescatalog.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRatingDao extends JpaRepository<Rating,Long> {

}
