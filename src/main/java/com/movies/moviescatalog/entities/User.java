
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
@Table(name="users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    
    private String name;
    private String email;
    private String password;
    private String user_role;
        
    // Creator
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    //private List<Movie> movies_created ;
    
}
