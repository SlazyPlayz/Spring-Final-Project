package bg.softuni.springexam.service;

import bg.softuni.springexam.model.enums.Role;

public interface RoleService {

    boolean roleExists(Role role);

    void addRole(Role role);
}
