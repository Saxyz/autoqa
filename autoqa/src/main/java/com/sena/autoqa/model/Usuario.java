package com.sena.autoqa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "usuarios")
public class Usuario {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "El nombre no debe contener ñ, tildes o caracteres especiales")
    private String nombre;

    @NotBlank(message = "El correo es requerido")
    @Email(message = "Debe ser un correo electrónico válido")
    @Column(unique = true)
    private String correo;

    @NotBlank(message = "La contraseña es requerida")
    @Pattern(regexp = "^[a-zA-Z0-9@#\\$%&]+$", message = "La contraseña no debe contener ñ, tildes o caracteres especiales")
    @Column(name = "contraseña")
    private String contrasena;

    @Pattern(regexp = "^[a-zA-Z0-9@#\\$%&]*$", message = "El tokenJira no debe contener ñ, tildes o caracteres especiales")
    private String tokenJira;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "participacionesporproyecto",   // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "idUsuario"),   // Columna de clave externa a la tabla Usuarios
            inverseJoinColumns = @JoinColumn(name = "idProyecto") // Columna de clave externa a la tabla Proyectos
    )
    private Set<Proyecto> proyectos = new HashSet<>();

    // Constructores
    public Usuario() {
        // Constructor vacío necesario para Hibernate
    }

    public Usuario(Integer id, String nombre, String correo, String contrasena, String tokenJira) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tokenJira = tokenJira;
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

    public String getcontrasena() {
        return contrasena;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", tokenJira='" + tokenJira + '\'' +
                '}';
    }
}
