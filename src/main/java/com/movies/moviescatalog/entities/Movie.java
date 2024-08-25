/**
 * @author Mario Efrain Moreno Cartagena
 * email: morenocartagena@outlook.com
 */

package com.movies.moviescatalog.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name="movies")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movie_id;
    
    private String name;
    private Integer releaseyear;
    private String synopsis;    
    private String category;    
    private String poster_url;
    private Double rating;
    
    @Temporal(TemporalType.DATE)
    private Date created_date;
    
    // Created By   
    //@Column(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id")
    @JoinColumn(name = "creator", referencedColumnName = "user_id")
    private User user;
    
}
