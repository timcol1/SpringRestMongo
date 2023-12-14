package avlyakulov.timur.SpringRestMongo.movie.service;

import avlyakulov.timur.SpringRestMongo.movie.model.Movie;
import avlyakulov.timur.SpringRestMongo.movie.model.Review;
import avlyakulov.timur.SpringRestMongo.movie.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {

    private ReviewRepository reviewRepository;

    private MongoTemplate mongoTemplate;


    public Review createReview(String imdbId, String reviewBody) {
        Review review = reviewRepository.save(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
