package avlyakulov.timur.SpringRestMongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Document(collection = "students")
@Data
public class Student {

    private String id;
    private String name;
    private String age;

    @Indexed(unique = true)
    private String numberPassport;

    private String fullName;
}