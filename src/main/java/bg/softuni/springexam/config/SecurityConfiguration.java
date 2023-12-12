package bg.softuni.springexam.config;

import bg.softuni.springexam.model.enums.Role;
import bg.softuni.springexam.repository.UserRepository;
import bg.softuni.springexam.service.impl.DieterUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private final String rememberMeKey;

    public SecurityConfiguration(@Value("${dieter.remember.me.key}") String rememberMeKey) {
        this.rememberMeKey = rememberMeKey;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                        // Define which URLs are visible by which users
                        authorizeRequests -> authorizeRequests
                                // All static resources which are situated in css, img, js are available for anyone
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                // Allow anyone to see the home page, registration page and login form
                                .requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll()
                                .requestMatchers("/recipes/all", "/recipes/add").permitAll()
                                .requestMatchers("/diets/all", "/diets/add").permitAll()
                                .requestMatchers("/error").permitAll()
//                                .requestMatchers("/brands").hasRole(Role.ADMIN.name())
//                                TODO: Add fix permissions
                                // All other requests are authenticated
                                .anyRequest().authenticated()
                ).formLogin(
                        formLogin -> {
                            formLogin
                                    // redirect here when we access something which is not allowed
                                    // also this is the page where we perform login
                                    .loginPage("/users/login")
                                    //The names of the input fields
                                    .usernameParameter("username")
                                    .passwordParameter("password")
                                    .defaultSuccessUrl("/")
                                    .failureForwardUrl("/users/login-error");
                        }
                ).logout(
                        logout -> {
                            logout
                                    // the URL where we should POST something in order to perform the logout
                                    .logoutUrl("/users/logout")
                                    // where to go when logged out?
                                    .logoutSuccessUrl("/")
                                    // invalidate the HTTP session
                                    .invalidateHttpSession(true);
                        }
                ).rememberMe(
                        rememberMe -> {
                            rememberMe.key(rememberMeKey)
                                    .rememberMeParameter("remember-me")
                                    .rememberMeCookieName("remember-me");
                        }
                )
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        // This service translates between the app users and roles
        // to a representation which spring security understands
        return new DieterUserDetailsServiceImpl(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}
