
package com.movies.moviescatalog.dto;

import com.movies.moviescatalog.entities.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieDto implements Serializable {
    
    private Long movie_id;    
    private String name;
    private Long release_year;
    private String synopsis;    
    private String category;    
    private String poster_url;
    private Double rating;
    
    @Temporal(TemporalType.DATE)
    private Date created_date;
    
    // Created By      
    private Long user_id;
    
}
