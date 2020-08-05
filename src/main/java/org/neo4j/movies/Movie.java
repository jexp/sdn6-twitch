package org.neo4j.movies;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Movie {
    @Id @GeneratedValue
    Long id;
    String title;
    int released;
    String tagline;
    @Relationship(type="ACTED_IN", direction = Relationship.Direction.INCOMING)
    List<Person> cast = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getReleased() {
        return released;
    }

    public String getTagline() {
        return tagline;
    }

    public List<Person> getCast() {
        return cast;
    }
}
