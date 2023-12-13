package bg.softuni.springexam.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    @Column(name = "ingredients")
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "recipes_ingredients",
//            joinColumns = @JoinColumn(name = "recipe_id"),
//            inverseJoinColumns = @JoinColumn(name = "recipe_ingredient_id")
//    )
    private Map<IngredientEntity, Integer> ingredients;

    @Column(name = "image-url")
    private String imageUrl;

    @ManyToOne
    private UserEntity author;

    @Column(name = "created")
    private LocalDateTime created;

    public String getName() {
        return name;
    }

    public RecipeEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Map<IngredientEntity, Integer> getIngredients() {
        return ingredients;
    }

    public RecipeEntity setIngredients(Map<IngredientEntity, Integer> ingredients) {
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
