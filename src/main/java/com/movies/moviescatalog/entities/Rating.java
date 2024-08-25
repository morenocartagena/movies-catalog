
package com.movies.moviescatalog.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Mario Efrain Moreno Cartagena
 */

@Data
@Entity
@Table(name="ratings")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rating implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rating_id;
    private Long user_id;
    //private Long movieid;
    private Double rating;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<User> users;    
    //private User user; 
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;
    
}
