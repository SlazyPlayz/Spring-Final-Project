package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.model.entity.RoleEntity;
import bg.softuni.springexam.model.entity.UserEntity;
import bg.softuni.springexam.repository.UserRepository;
import bg.softuni.springexam.service.DieterUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DieterUserDetailsServiceImpl implements DieterUserDetailsService {

    private final UserRepository userRepository;

    public DieterUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(DieterUserDetailsServiceImpl::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }

    private static UserDetails map(UserEntity user) {
        return User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRoles().stream().map(DieterUserDetailsServiceImpl::map).toList())
                .build();
    }

    private static GrantedAuthority map(RoleEntity role) {
        return new SimpleGrantedAuthority(
                "ROLE_" + role.getRole().name()
        );
    }
}
