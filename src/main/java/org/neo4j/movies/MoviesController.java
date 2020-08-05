package org.neo4j.movies;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.websocket.server.PathParam;
import java.time.Duration;
import java.util.List;

@RestController
public class MoviesController {

    final MovieService service;

    public MoviesController(MovieService service) {
        this.service = service;
    }

    // curl http://localhost:8080/titles
    @GetMapping(value = "/titles", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> titles() {
        return service.rxMovies().delayElements(Duration.ofMillis(250)).map(m -> m.title);
    }

    // curl http://localhost:8080/byYear/1995
    @GetMapping("/nodes/{label}")
    public int nodeCount(@PathVariable String label) {
        return service.nodeCount(label);
    }

    // curl http://localhost:8080/byYear/1995
    @GetMapping(value = "/byYear/{year}")
    public List<Movie> byYear(@PathVariable int year) {
        return service.byYear(year);
    }

    // curl http://localhost:8080/tagline?text=one
    @GetMapping(value = "/tagline")
    public List<Movie> byYear(@RequestParam("text") String text) {
        return service.taglineContains(text);
    }

    // curl http://localhost:8080/acting/Tom%20Hanks/Sleepless%20in%20Seattle -XPOST
    @PostMapping(value = "/acting/{person}/{movie}")
    public List<Person> acting(@PathVariable("person") String person,@PathVariable("movie") String movie) {
        return service.actedIn(person,movie);
    }
}
