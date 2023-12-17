package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.model.entity.RoleEntity;
import bg.softuni.springexam.model.enums.Role;
import bg.softuni.springexam.repository.RoleRepository;
import bg.softuni.springexam.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean roleExists(Role role) {
        return roleRepository.findByRole(role).isPresent();
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(new RoleEntity().setRole(role));
    }
}
