package com.generation1.generation1.service;

import java.util.List;

import com.generation1.generation1.model.User;

public interface UserService {

    User getUser(Integer id);

    User save(User user);

    void delete(Integer id);

    List<User> getAllUsers();

}
