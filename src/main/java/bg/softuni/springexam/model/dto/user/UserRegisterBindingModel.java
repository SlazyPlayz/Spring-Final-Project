package bg.softuni.springexam.model.dto.user;

import bg.softuni.springexam.validation.FieldMatch;
import bg.softuni.springexam.validation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Password and confirm password must match"
)
public record UserRegisterBindingModel (

    @Size(min = 3, max = 24, message = "Username must be between 3 and 24 characters")
    String username,

    @NotNull
    @Email(message = "Invalid email")
    @UniqueEmail
    @Size(min = 3, message = "Email must be at least 3 characters long")
    String email,

    @NotEmpty
    String firstName,

    @NotEmpty
    String lastName,

    @Size(min = 8, message = "Password must be at least 8 characters long")
    String password,

    @Size(min = 8, message = "Password must be at least 8 characters long")
    String confirmPassword) {

}
