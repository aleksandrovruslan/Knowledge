package com.aleksandrov.Knowledge.repositories;

import com.aleksandrov.Knowledge.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User getById(long id);
}
