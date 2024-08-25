/**
 * @author Mario Efrain Moreno Cartagena
 * email: morenocartagena@outlook.com
 */

package com.movies.moviescatalog.configuration;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.servers.Server;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "MOVIES CATALOG",
                description = "An API to manage a movie catalog.",
                version = "1.0.0",
                contact = @Contact(
                        name = "Mario Efraín Moreno Cartagena",
                        url = "https://github.com/morenocartagena",
                        email = "morenocartagena@outlook.com"                
                )
        ),
        servers = {
            @Server(
                    description = "DEV SERVER",
                    url = "http://localhost:8085/movies-catalog"
            ),
            @Server(
                    description = "PROD SERVER",
                    url = "http://pending:8085/movies-catalog"
            )         
        }      
)
public class SwaggerConfig {}
