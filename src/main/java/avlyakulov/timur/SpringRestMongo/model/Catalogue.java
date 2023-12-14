package avlyakulov.timur.SpringRestMongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;


@Data
@Document(collection = "catalogue")
public class Catalogue {

    @Id
    private String id;

    //@Indexed(unique = true)
    private String name;

    @DocumentReference
    private List<Brand> brands;
}