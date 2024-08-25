package com.sena.autoqa.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proyectos")
public class Proyecto {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProyecto")
    private Integer id;
    private String titulo;
    private String descripcion;
    @Transient
    @ManyToMany(mappedBy = "proyectos")
    private Set<Usuario> usuarios = new HashSet<>();


    //Constructor
    public Proyecto(Integer id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    //Constructor vacio necesario para hibernate
    public Proyecto() {
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }
}
