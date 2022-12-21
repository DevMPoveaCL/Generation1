package com.generation1.generation1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.generation1.generation1.model.User;
import com.generation1.generation1.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    // esto verifica que la conexion a la bbdd está correcta.
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Integer id) {

        // select * from user where id = id;
        Optional<User> users = userRepository.findById(id);

        // El orElse permite verificar si hay o no datos en la lista,
        // en caso de haber devuelve el usuario, sino un nulo.
        return users.orElse(null);
    }

    @Override
    public User save(User user) {
        // insert into user (columns)(values)
        return userRepository.save(user);

    }

    @Override
    public void delete(Integer id) {
        // delete from user where id = id
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
