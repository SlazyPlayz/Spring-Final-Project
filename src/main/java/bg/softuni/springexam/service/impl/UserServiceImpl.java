package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.exception.RecipeNotFoundException;
import bg.softuni.springexam.exception.RoleNotFoundException;
import bg.softuni.springexam.model.dto.user.UserRegisterBindingModel;
import bg.softuni.springexam.model.entity.RoleEntity;
import bg.softuni.springexam.model.entity.UserEntity;
import bg.softuni.springexam.model.enums.Role;
import bg.softuni.springexam.repository.RecipeRepository;
import bg.softuni.springexam.repository.RoleRepository;
import bg.softuni.springexam.repository.UserRepository;
import bg.softuni.springexam.service.RecipeService;
import bg.softuni.springexam.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final RecipeRepository recipeRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository,
                           RecipeRepository recipeRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {

        RoleEntity role = roleRepository.findByRole(Role.USER).orElseThrow(() -> new RoleNotFoundException(Role.USER));

        UserEntity user = new UserEntity()
                .setUsername(userRegisterBindingModel.username())
                .setEmail(userRegisterBindingModel.email())
                .setPassword(passwordEncoder.encode(userRegisterBindingModel.password()))
                .setFirstName(userRegisterBindingModel.firstName())
                .setLastName(userRegisterBindingModel.lastName())
                .setBanned(false)
                .setRoles(Set.of(role))
                .setCreated(LocalDateTime.now());

        userRepository.save(user);
    }

    @Override
    public UserEntity loggedUser() {
        String currentUserName;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        } else {
            currentUserName = "";
        }

        return userRepository
                .findByUsername(currentUserName)
                .orElse(null);
//                .orElseThrow(() -> new UserNotFoundException(currentUserName));
    }

    @Override
    public void addFavourite(UUID recipeId) {
        loggedUser().addFavouriteRecipe(
                recipeRepository
                        .findById(recipeId)
                        .orElseThrow(() -> new RecipeNotFoundException(recipeId))
        );

        userRepository.save(loggedUser());
    }

    @Override
    public void removeFavourite(UUID recipeId) {
        loggedUser().removeFavouriteRecipe(
                recipeRepository
                        .findById(recipeId)
                        .orElseThrow(() -> new RecipeNotFoundException(recipeId))
        );

        userRepository.save(loggedUser());
    }

    @Override
    public boolean isFavourite(UUID recipeId) {
        if (loggedUser() != null) {
            return loggedUser().getFavouriteRecipes().stream().anyMatch(x -> x.getId().equals(recipeId));
        }
        return false;
    }
}
