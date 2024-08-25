/**
 * @author Mario Efrain Moreno Cartagena
 * email: morenocartagena@outlook.com
 */

package com.movies.moviescatalog;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

//@OpenAPIDefinition
@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
public class MoviesCatalog {

    public static void main(String[] args) {
    SpringApplication.run(MoviesCatalog.class, args);


    }

}
