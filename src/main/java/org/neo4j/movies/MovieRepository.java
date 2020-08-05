package org.neo4j.movies;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// http://localhost:8080/movies
@RepositoryRestResource
public interface MovieRepository extends Neo4jRepository<Movie,Long> {

    Movie findByTitle(String title);
    List<Movie> findByTaglineContains(String s);

    // from twitch session
    List<Movie> findByReleased(int year);
    @Query("MATCH (n:Movie) WHERE n.tagline contains $text RETURN n")
    List<Movie> taglineContains(String text);

}
