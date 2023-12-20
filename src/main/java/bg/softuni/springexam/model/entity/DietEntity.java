package bg.softuni.springexam.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "diets")
public class DietEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "diets_recipes",
            joinColumns = { @JoinColumn(name = "diet_id") },
            inverseJoinColumns = { @JoinColumn(name = "recipe_id") }
    )
    private List<RecipeEntity> recipes;

    @ManyToOne
    private DietTypeEntity type;

    @ManyToOne
    private UserEntity author;

    @Column(name = "created")
    private LocalDateTime created;

    public DietEntity() {
        recipes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public DietEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DietEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public DietEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public DietEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public DietTypeEntity getType() {
        return type;
    }

    public DietEntity setType(DietTypeEntity type) {
        this.type = type;
        return this;
    }

    public List<RecipeEntity> getRecipes() {
        return recipes;
    }

    public DietEntity setRecipes(List<RecipeEntity> recipes) {
        this.recipes = recipes;
        return this;
    }
}
