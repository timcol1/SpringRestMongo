package avlyakulov.timur.SpringRestMongo.movie.controller;

import avlyakulov.timur.SpringRestMongo.movie.model.Review;
import avlyakulov.timur.SpringRestMongo.movie.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/reviews")
@AllArgsConstructor
public class ReviewController {

    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(reviewService.createReview(
                payload.get("imdbId"),
                payload.get("reviewBody")
        ));
    }

}