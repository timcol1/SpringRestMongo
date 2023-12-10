package avlyakulov.timur.SpringRestMongo.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ModelNotFoundException extends ResponseStatusException {

    public ModelNotFoundException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
