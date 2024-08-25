package com.sena.autoqa.service.interfaces;

import com.sena.autoqa.model.Usuario;

import java.util.List;

public interface CrudService<T, ID> {
    T save(T entity); //Funciona para guardar y actualizar, en el Controller se hace la desicion
    List<T> findAll();
    T findById(ID id);
    T update(ID id, T entity);
    void deleteById(ID id);
}
