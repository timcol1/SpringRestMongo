package avlyakulov.timur.SpringRestMongo;

import avlyakulov.timur.SpringRestMongo.model.Address;
import avlyakulov.timur.SpringRestMongo.model.Device;
import avlyakulov.timur.SpringRestMongo.model.Gender;
import avlyakulov.timur.SpringRestMongo.model.Student;
import avlyakulov.timur.SpringRestMongo.repository.DeviceRepository;
import avlyakulov.timur.SpringRestMongo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringRestMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestMongoApplication.class, args);
    }

    /*@Bean
    CommandLineRunner runner(StudentRepository repository, DeviceRepository deviceRepository, MongoTemplate mongoTemplate) {
        return args -> {
            Device device = new Device("Iphone 14 pro max");

            deviceRepository.save(device);

            Student student = new Student(
                    "Timur",
                    "21",
                    "1145",
                    device
            );

            //usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
            repository.save(student);
        };
    }*/

    /*private static void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        List<Student> students = mongoTemplate.find(query, Student.class);

        if (students.size() > 1) {
            throw new IllegalStateException("Found many student with email " + email);
        }

        if (students.isEmpty()) {
            System.out.println("Inserting student " + student);
            repository.insert(student);
        } else {
            System.out.println(student + " already exists");
        }
    }*/

}