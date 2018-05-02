package com.aleksandrov.Knowledge.services.User;

import com.aleksandrov.Knowledge.exceptions.User.UserNotFoundException;
import com.aleksandrov.Knowledge.models.User;
import com.aleksandrov.Knowledge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(long id) {
        return findUser(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        findUser(id);
        userRepository.deleteById(id);
    }

    @Override
    public User editUser(User user) {
        findUser(user.getId());
        return userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        List<User> users = new LinkedList<>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    private User findUser(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User id " + id + " not found."));
    }
}
