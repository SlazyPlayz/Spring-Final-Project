package bg.softuni.springexam.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ingredients")
public class IngredientEntity extends BaseEntity {

    @Column(name = "ingredient")
    private String ingredient;

    @Column(name = "dietary_restrictions")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ingredients_restrictions",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "restriction_id")
    )
    private List<DietaryRestrictionsEntity> restrictions;

    public String getIngredient() {
        return ingredient;
    }

    public IngredientEntity setIngredient(String ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public List<DietaryRestrictionsEntity> getRestrictions() {
        return restrictions;
    }

    public IngredientEntity setRestrictions(List<DietaryRestrictionsEntity> restrictions) {
        this.restrictions = restrictions;
        return this;
    }
}
