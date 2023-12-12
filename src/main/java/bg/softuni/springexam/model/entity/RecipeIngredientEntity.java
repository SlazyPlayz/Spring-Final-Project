package bg.softuni.springexam.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredientEntity extends BaseEntity {

    @ManyToOne
    private IngredientEntity ingredient;

    @Column(name = "amount")
    private int amount;

    public IngredientEntity getIngredient() {
        return ingredient;
    }

    public RecipeIngredientEntity setIngredient(IngredientEntity ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public RecipeIngredientEntity setAmount(int amount) {
        this.amount = amount;
        return this;
    }

}
