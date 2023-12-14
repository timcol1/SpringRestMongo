package avlyakulov.timur.SpringRestMongo.movie.service;

import avlyakulov.timur.SpringRestMongo.movie.model.Movie;
import avlyakulov.timur.SpringRestMongo.movie.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(ObjectId objectId) {
        return movieRepository.findById(objectId).orElseThrow(() -> new RuntimeException("Movie with such id doesn't exist"));
    }

    public Movie getMovieByImdbId(String imdbId) {
        return movieRepository.findByImdbId(imdbId).orElseThrow(() -> new RuntimeException("Movie with such imdbId doesn't exist"));
    }


}
