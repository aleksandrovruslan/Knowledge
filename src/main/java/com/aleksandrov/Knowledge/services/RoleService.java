package com.aleksandrov.Knowledge.services;

import com.aleksandrov.Knowledge.models.Role;

public interface RoleService {
    Role getRole(int id);
    Role saveRole(Role role);
    void deleteRole(int id);
    Iterable<Role> getRoles();
}
