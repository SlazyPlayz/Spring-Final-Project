package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.exception.UserNotFoundException;
import bg.softuni.springexam.model.dto.UserRegisterBindingModel;
import bg.softuni.springexam.model.entity.UserEntity;
import bg.softuni.springexam.repository.UserRepository;
import bg.softuni.springexam.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        UserEntity user = new UserEntity()
                .setUsername(userRegisterBindingModel.username())
                .setEmail(userRegisterBindingModel.email())
                .setPassword(passwordEncoder.encode(userRegisterBindingModel.password()))
                .setFirstName(userRegisterBindingModel.firstName())
                .setLastName(userRegisterBindingModel.lastName())
                .setCreated(LocalDateTime.now());

        userRepository.save(user);
    }

    @Override
    public UserEntity loggedUser() {
        String currentUserName;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        } else {
            currentUserName = "";
        }

        return userRepository
                .findByUsername(currentUserName)
                .orElseThrow(() -> new UserNotFoundException(currentUserName));
    }
}
