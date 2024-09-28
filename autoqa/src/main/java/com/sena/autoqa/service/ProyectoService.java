package com.sena.autoqa.service;

import com.sena.autoqa.model.Proyecto;
import com.sena.autoqa.repository.ProyectoRepository;
import com.sena.autoqa.service.interfaces.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ProyectoService implements CrudService<Proyecto, Integer> {

    private final ProyectoRepository proyectoRepository;

    //Inyeccion de dependencias
    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    //Implementacion de metodos CRUD
    @Override
    public Proyecto save(Proyecto entity) {
        return proyectoRepository.save(entity);
    }

    @Override
    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto findById(Integer id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public Proyecto update(Integer id, Proyecto entity) {
        if (!proyectoRepository.existsById(id)) {
            throw new NoSuchElementException("Usuario no encontrado");
        }
        entity.setId(id);
        return proyectoRepository.save(entity);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (!proyectoRepository.existsById(id)) {
            throw new NoSuchElementException("Usuario no encontrado");
        }
        proyectoRepository.deleteById(id);
        return true;
    }
}
