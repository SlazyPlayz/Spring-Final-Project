package bg.softuni.springexam.model.dto;

import java.util.Objects;

public final class RecipeIngredientDTO {
    private String name;
    private int amount;


    public RecipeIngredientDTO() {
        this.name = "";
        this.amount = 0;
    }

//    public static RecipeIngredientDTO empty() {
//        return new RecipeIngredientDTO("", 0);
//    }


    public RecipeIngredientDTO(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public RecipeIngredientDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public RecipeIngredientDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
