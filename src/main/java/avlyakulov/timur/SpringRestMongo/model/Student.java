package avlyakulov.timur.SpringRestMongo.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Document(collection = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private ObjectId id;
    private String name;
    private String age;

    @Indexed(unique = true)
    private String numberPassport;


    @Field("device")
    @DocumentReference(collection = "devices")
    private List<Device> deviceIds;


}