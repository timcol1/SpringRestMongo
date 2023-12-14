package avlyakulov.timur.SpringRestMongo.movie.repository;

import avlyakulov.timur.SpringRestMongo.movie.model.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId>  {

}
