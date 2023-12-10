package avlyakulov.timur.SpringRestMongo.repository;

import avlyakulov.timur.SpringRestMongo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findStudentByNumberPassport(String numberPassport);
}