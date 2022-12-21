package com.generation1.generation1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import com.fasterxml.jackson.annotation.JsonBackReference;

// Le vamos a poner el nombgre a nuestra tabla en la BD
@Entity(name = "User")
public class User {
    // Le especificamos a la base que el sig atributo será el id de la tabla
    @Id
    // generamos la llave primaria
    @GeneratedValue
    // Definimos el atributo id, debe ser igual al del constructor "int id", sino no
    // me dejará meter la query sin id en postman
    private int id;
    private String name;
    // Cambia-Asigna el nombre de la bbdd al programa, en postman se debe
    // poner lastName, es decir la variable original en "private"
    @Column(name = "last_name")
    private String lastName;
    // unique hace que no se repita
    @Column(name = "email", unique = true)
    private String correo;

    // relacion one to one
    // @JsonBackReference
    // Lazy para one to one
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private License license;

    // @JsonBackReference
    // cuando se envía es eager en una onetomany
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuySell> buySell;

    public User() {
    }

    public User(int id, String name, String lastName, String correo) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
