package bg.softuni.springexam.model.dto.user;

import jakarta.validation.constraints.Size;

public record UserLoginBindingModel(

        @Size(min = 3, max = 24, message = "Username must be between 3 and 24 characters")
        String username,

        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password) {
}
