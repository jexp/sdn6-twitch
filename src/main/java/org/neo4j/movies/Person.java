package org.neo4j.movies;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Person {
    @Id
    String name;
    int born;

    public String getName() {
        return name;
    }

    public int getBorn() {
        return born;
    }
}
