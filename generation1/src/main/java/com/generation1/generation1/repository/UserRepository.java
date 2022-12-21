package com.generation1.generation1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generation1.generation1.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Nombre
    @Query(value = "select * from user where name = ?1", nativeQuery = true)
    List<User> findAllName(String name);

    // apellido
    @Query(value = "select * from user where lastName = ?1", nativeQuery = true)
    List<User> findAllLastName(String lastName);

    // Id y correo
    @Query(value = "select * from user where id = ?1 and correo = ?2", nativeQuery = true)
    List<User> findAllIdCorreo(Integer id, String correo);
}
