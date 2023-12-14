package avlyakulov.timur.SpringRestMongo.repository;

import avlyakulov.timur.SpringRestMongo.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {

}