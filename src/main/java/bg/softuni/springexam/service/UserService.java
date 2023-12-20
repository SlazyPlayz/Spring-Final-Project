package bg.softuni.springexam.service;

import bg.softuni.springexam.model.dto.user.UserRegisterBindingModel;
import bg.softuni.springexam.model.entity.UserEntity;

import java.util.UUID;

public interface UserService {

    void register(UserRegisterBindingModel userRegisterBindingModel);

    UserEntity loggedUser();

    void addFavourite(UUID recipeId);

    void removeFavourite(UUID recipeId);

    boolean isFavourite(UUID recipeId);
}
