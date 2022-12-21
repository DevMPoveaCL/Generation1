package com.generation1.generation1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generation1.generation1.model.License;

@Repository
public interface LicenseRepository extends JpaRepository<License, Integer> {
    // Tipo de Licencia A, B, C
    @Query(value = "select * from license where clase = ?1", nativeQuery = true)
    List<License> findAllClase(String clase);

    // Estado
    @Query(value = "select * from license where estado = ?1", nativeQuery = true)
    List<License> findAllEstado(String estado);

    // Estado y clase
    @Query(value = "select * from license where estado = ?1 and clase = ?2", nativeQuery = true)
    List<License> findAllEstadoClase(String estado, String clase);

    // Fecha de vencimiento & usuario
    // @Query(value = "select * form license l join u.user u", nativeQuery = true)
    // //preguntar???
    // List <License> buscaFechaVencimientoDelUsuario();

}
