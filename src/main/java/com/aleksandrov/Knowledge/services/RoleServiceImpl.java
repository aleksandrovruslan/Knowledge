package com.aleksandrov.Knowledge.services;

import com.aleksandrov.Knowledge.models.Role;
import com.aleksandrov.Knowledge.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRole(int id) {
        return roleRepository.getById(id);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Iterable<Role> getRoles() {
        return roleRepository.findAll();
    }
}
