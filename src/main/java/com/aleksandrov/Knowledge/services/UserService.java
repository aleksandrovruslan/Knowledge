package com.aleksandrov.Knowledge.services;

import com.aleksandrov.Knowledge.models.User;

public interface UserService {
    User getUser(long id);
    User saveUser(User user);
    void deleteUser(long id);
}
