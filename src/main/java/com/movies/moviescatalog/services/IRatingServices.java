package com.movies.moviescatalog.services;

import com.movies.moviescatalog.entities.Rating;

import java.util.List;

public interface IRatingServices {

    List<Rating> retrieveAllRatings();

    Rating addOrUpdateRating(Rating r);

    Rating retrieveRating (Long rating_id);

    void deleteRating (Long rating_id);

    //public List<Rating> searchRatingsByName(String name);
    
    //public List<Rating> searchRatingsBySynopsis(String synopsis);

}
