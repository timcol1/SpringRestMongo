package avlyakulov.timur.SpringRestMongo.movie.controller;

import avlyakulov.timur.SpringRestMongo.movie.model.Movie;
import avlyakulov.timur.SpringRestMongo.movie.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String imdbId) {
        return ResponseEntity.ok(movieService.getMovieByImdbId(imdbId));
    }
}
