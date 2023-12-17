package bg.softuni.springexam.model.dto.ingredient;

import bg.softuni.springexam.model.dto.user.UserDTO;
import bg.softuni.springexam.model.enums.DietaryRestriction;

import java.util.HashSet;
import java.util.Set;

public class IngredientAddBindingModel {

    private String name;

    private Set<DietaryRestriction> restrictions;

    private UserDTO author;

    public IngredientAddBindingModel() {
        this.restrictions = new HashSet<>();
    }

    public static IngredientAddBindingModel empty() {
        return new IngredientAddBindingModel();
    }

    public String getName() {
        return name;
    }

    public IngredientAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Set<DietaryRestriction> getRestrictions() {
        return restrictions;
    }

    public IngredientAddBindingModel setRestrictions(Set<DietaryRestriction> restrictions) {
        this.restrictions = restrictions;
        return this;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public IngredientAddBindingModel setAuthor(UserDTO author) {
        this.author = author;
        return this;
    }
}
