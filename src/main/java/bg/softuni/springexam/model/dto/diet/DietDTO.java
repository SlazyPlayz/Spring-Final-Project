package bg.softuni.springexam.model.dto.diet;

import bg.softuni.springexam.model.dto.recipe.RecipeDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class DietDTO {
    private UUID id;
    private String name;
    private String description;
    private List<RecipeDTO> recipes;
    private String authorName;
    private LocalDateTime created;

    public UUID getId() {
        return id;
    }

    public DietDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DietDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DietDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<RecipeDTO> getRecipes() {
        return recipes;
    }

    public DietDTO setRecipes(List<RecipeDTO> recipes) {
        this.recipes = recipes;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public DietDTO setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public DietDTO setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }
}
