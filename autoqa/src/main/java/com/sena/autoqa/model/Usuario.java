package com.sena.autoqa.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer id;
    private String nombre;
    @Column(unique = true)
    private String correo;
    @Column(name = "contraseña")
    private String contrasenia;
    private String tokenJira;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "participacionesporproyecto",   // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "idUsuario"),   // Columna de clave externa a la tabla Usuarios
            inverseJoinColumns = @JoinColumn(name = "idProyecto")
    ) //Relacion con proyectos
    private Set<Proyecto> proyectos = new HashSet<>();


    //Constructor
    public Usuario(Integer id, String nombre, String correo, String contrasenia, String tokenJira) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.tokenJira = tokenJira;
    }

    //Constructor vacio necesario para hibernate
    public Usuario() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTokenJira() {
        return tokenJira;
    }

    public void setTokenJira(String tokenJira) {
        this.tokenJira = tokenJira;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "tokenJira='" + tokenJira + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
