package avlyakulov.timur.SpringRestMongo.repository;

import avlyakulov.timur.SpringRestMongo.model.Student;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentCriteriaRepositoryImpl {

    private final MongoTemplate template;

    public List<Student> findAll(@NonNull Query query) {
        return template.find(query, Student.class);
    }
}
