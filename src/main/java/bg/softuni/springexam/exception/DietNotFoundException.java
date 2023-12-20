package bg.softuni.springexam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DietNotFoundException extends RuntimeException {

    public DietNotFoundException(UUID id) {
        super("Diet with id: " + id + " was not found!");
    }
}
