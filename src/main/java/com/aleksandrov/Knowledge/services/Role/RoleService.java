package com.aleksandrov.Knowledge.services.Role;

import com.aleksandrov.Knowledge.models.Role;

import java.util.List;

public interface RoleService {
    Role getRole(int id);
    Role saveRole(Role role);
    void deleteRole(int id);
    Role editRoles(Role role);
    List<Role> getRoles();
}
