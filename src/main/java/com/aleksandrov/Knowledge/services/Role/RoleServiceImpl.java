package com.aleksandrov.Knowledge.services.Role;

import com.aleksandrov.Knowledge.exceptions.Role.RoleNotFoundException;
import com.aleksandrov.Knowledge.models.Role;
import com.aleksandrov.Knowledge.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRole(int id) {
        return findRole(id);
    }

    @Override
    public Role saveRole(Role role) {
        findRole(role.getId());
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(int id) {
        findRole(id);
        roleRepository.deleteById(id);
    }

    @Override
    public Role editRoles(Role role) {
        findRole(role.getId());
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getRoles() {
        List<Role> roles = new LinkedList<>();
        roleRepository.findAll().forEach((r) -> roles.add(r));
        return roles;
    }

    private Role findRole(int id) {
        return roleRepository.findById(id).orElseThrow(() ->
                new RoleNotFoundException("Role id " + id + " not found."));
    }
}
