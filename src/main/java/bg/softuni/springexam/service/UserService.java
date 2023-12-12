package bg.softuni.springexam.service;

import bg.softuni.springexam.model.dto.UserRegisterBindingModel;
import bg.softuni.springexam.model.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    void register(UserRegisterBindingModel userRegisterBindingModel);

    UserEntity loggedUser();
}
