package bg.softuni.springexam.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "recipes")
public class RecipeEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ElementCollection
    @JoinTable(
            name = "recipes_ingredients",
            joinColumns = { @JoinColumn(name = "recipe_id") }
    )
    @MapKeyJoinColumn(name = "ingredient_id")
    private Map<IngredientEntity, Double> ingredients;

    @Column(name = "image-url")
    private String imageUrl;

    @ManyToOne
    private UserEntity author;

    @Column(name = "created")
    private LocalDateTime created;

    public RecipeEntity() {
        ingredients = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public RecipeEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Map<IngredientEntity, Double> getIngredients() {
        return ingredients;
    }

    public RecipeEntity setIngredients(Map<IngredientEntity, Double> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RecipeEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public RecipeEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RecipeEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RecipeEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
