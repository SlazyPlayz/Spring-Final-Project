package bg.softuni.springexam.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "recipes")
public class RecipeEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "ingredients")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "recipes_ingredients",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<IngredientEntity> ingredients;

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

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public RecipeEntity setIngredients(List<IngredientEntity> ingredients) {
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
}
