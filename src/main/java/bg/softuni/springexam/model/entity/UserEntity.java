package bg.softuni.springexam.model.entity;

import bg.softuni.springexam.model.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<RoleEntity> roles;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_recipes",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "recipe_id") }
    )
    private List<RecipeEntity> favouriteRecipes;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "banned")
    private boolean isBanned;

    public UserEntity() {
        roles = new HashSet<>();
        favouriteRecipes = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public UserEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public UserEntity setBanned(boolean banned) {
        isBanned = banned;
        return this;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public UserEntity setFullName(String fullName) {
        String[] names = fullName.split("\\s+");
        this.firstName = names[0];
        this.lastName = names[1];
        return this;
    }

    public List<RecipeEntity> getFavouriteRecipes() {
        return favouriteRecipes;
    }

    public UserEntity setFavouriteRecipes(List<RecipeEntity> favouriteRecipes) {
        this.favouriteRecipes = favouriteRecipes;
        return this;
    }

    public UserEntity addFavouriteRecipe(RecipeEntity recipe) {
        this.favouriteRecipes.add(recipe);
        return this;
    }

    public UserEntity removeFavouriteRecipe(RecipeEntity recipe) {
        this.favouriteRecipes.remove(recipe);
        return this;
    }
}
