package com.movies.moviescatalog.services;

import com.movies.moviescatalog.entities.Rating;
//import com.movies.moviescatalog.entities.Universite;
import com.movies.moviescatalog.repositories.IRatingDao;
//import com.movies.moviescatalog.repositories.IUniversiteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServices implements IRatingServices {

    private final IRatingDao iRatingDao;

    @Override
    public List<Rating> retrieveAllRatings() {
        return iRatingDao.findAll();
    }

    @Override
    public Rating addOrUpdateRating(Rating r) {
        return iRatingDao.save(r);
    }

    @Override
    public Rating retrieveRating(Long rating_id) {
        return iRatingDao.findById(rating_id).orElse(null);
    }

    @Override
    public void deleteRating(Long rating_id) {
        iRatingDao.deleteById(rating_id);
    }

}
