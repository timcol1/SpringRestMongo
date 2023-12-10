package avlyakulov.timur.SpringRestMongo.repository;

import avlyakulov.timur.SpringRestMongo.model.Catalogue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueRepository extends MongoRepository<Catalogue, String> {
}
