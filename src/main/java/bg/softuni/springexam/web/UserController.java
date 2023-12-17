package bg.softuni.springexam.web;

import bg.softuni.springexam.model.dto.user.UserRegisterBindingModel;
import bg.softuni.springexam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/user/login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("/user/register");
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterBindingModel userRegisterBindingModel) {

        userService.register(userRegisterBindingModel);

        return new ModelAndView("redirect:/");
    }
}
