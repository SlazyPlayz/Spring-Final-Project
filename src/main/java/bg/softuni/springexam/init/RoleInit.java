package bg.softuni.springexam.init;

import bg.softuni.springexam.model.entity.RoleEntity;
import bg.softuni.springexam.model.enums.Role;
import bg.softuni.springexam.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInit implements CommandLineRunner {

    private final RoleService roleService;

    public RoleInit(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        for (Role role : Role.values()) {
            if (!roleService.roleExists(role))
                roleService.addRole(role);
        }
    }
}
