package avlyakulov.timur.SpringRestMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@AllArgsConstructor
@Document
public class Address {
    private String country;
    private String city;
    private String postCode;
}