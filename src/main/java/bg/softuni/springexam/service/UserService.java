package bg.softuni.springexam.service;

import bg.softuni.springexam.model.dto.user.UserRegisterBindingModel;
import bg.softuni.springexam.model.entity.UserEntity;

public interface UserService {

    void register(UserRegisterBindingModel userRegisterBindingModel);

    UserEntity loggedUser();
}
