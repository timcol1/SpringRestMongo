package avlyakulov.timur.SpringRestMongo.dto;

import avlyakulov.timur.SpringRestMongo.model.Address;
import avlyakulov.timur.SpringRestMongo.model.Gender;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record StudentDTO(
        String id,
        String firstName,
        String lastName,
        String email,
        Gender gender,
        Address address,
        List<String>favouriteSubjects,
        BigDecimal totalSpentInBooks,
        LocalDateTime createdAt,
        String favoriteBook
) {
}
