package bg.softuni.springexam.model.dto.diet;

import bg.softuni.springexam.model.dto.user.UserDTO;
import bg.softuni.springexam.model.enums.DietType;

public class DietAddBindingModel {

    private String name;
    private String description;
    private DietType type;
    private UserDTO author;

    public DietAddBindingModel(String name, String description, DietType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public DietAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DietAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public DietType getType() {
        return type;
    }

    public DietAddBindingModel setType(DietType type) {
        this.type = type;
        return this;
    }

    public static DietAddBindingModel empty() {
        return new DietAddBindingModel(null, null, null);
        //TODO: Do this for all other binding models.
    }

    public UserDTO getAuthor() {
        return author;
    }

    public DietAddBindingModel setAuthor(UserDTO author) {
        this.author = author;
        return this;
    }
}
