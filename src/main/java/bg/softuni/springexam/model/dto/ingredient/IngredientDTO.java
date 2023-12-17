package bg.softuni.springexam.model.dto.ingredient;

import bg.softuni.springexam.model.dto.user.UserDTO;
import bg.softuni.springexam.model.entity.DietaryRestrictionEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class IngredientDTO {
    private String name;
    private Set<DietaryRestrictionEntity> dietaryRestrictions;
    private UserDTO author;

    public IngredientDTO() {
        dietaryRestrictions = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public IngredientDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Set<DietaryRestrictionEntity> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public IngredientDTO setDietaryRestrictions(Set<DietaryRestrictionEntity> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
        return this;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public IngredientDTO setAuthor(UserDTO author) {
        this.author = author;
        return this;
    }
}
