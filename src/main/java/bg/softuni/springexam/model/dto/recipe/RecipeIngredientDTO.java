package bg.softuni.springexam.model.dto.recipe;

public final class RecipeIngredientDTO {
    private String name;
    private Double amount;


    public RecipeIngredientDTO() {
        this.name = "";
        this.amount = 0.0;
    }

//    public static RecipeIngredientDTO empty() {
//        return new RecipeIngredientDTO("", 0);
//    }


    public RecipeIngredientDTO(String name, Double amount) {
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

    public Double getAmount() {
        return amount;
    }

    public RecipeIngredientDTO setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
