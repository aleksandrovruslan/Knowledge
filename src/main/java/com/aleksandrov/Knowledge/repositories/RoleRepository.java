package com.aleksandrov.Knowledge.repositories;

import com.aleksandrov.Knowledge.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role getById(int id);
}
