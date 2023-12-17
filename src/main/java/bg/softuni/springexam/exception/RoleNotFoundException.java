package bg.softuni.springexam.exception;

import bg.softuni.springexam.model.enums.Role;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(Role role) {
        super("Role " + role.name() + " was not found!");
    }
}
