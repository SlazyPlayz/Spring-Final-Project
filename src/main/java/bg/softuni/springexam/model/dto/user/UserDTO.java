package bg.softuni.springexam.model.dto.user;

public class UserDTO {

    private String username;

    private String email;

    private String fullName;

    private String imageUrl;

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
