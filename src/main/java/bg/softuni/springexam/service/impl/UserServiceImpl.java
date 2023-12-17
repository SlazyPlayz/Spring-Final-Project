package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.exception.RoleNotFoundException;
import bg.softuni.springexam.exception.UserNotFoundException;
import bg.softuni.springexam.model.dto.user.UserRegisterBindingModel;
import bg.softuni.springexam.model.entity.RoleEntity;
import bg.softuni.springexam.model.entity.UserEntity;
import bg.softuni.springexam.model.enums.Role;
import bg.softuni.springexam.repository.RoleRepository;
import bg.softuni.springexam.repository.UserRepository;
import bg.softuni.springexam.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
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
}
