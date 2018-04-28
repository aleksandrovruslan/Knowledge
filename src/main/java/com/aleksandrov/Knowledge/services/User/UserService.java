package com.aleksandrov.Knowledge.services.User;

import com.aleksandrov.Knowledge.models.User;

import java.util.List;

public interface UserService {
    User getUser(long id);
    User saveUser(User user);
    void deleteUser(long id);
    User editUser(User user);
    List<User> listUsers();
}
