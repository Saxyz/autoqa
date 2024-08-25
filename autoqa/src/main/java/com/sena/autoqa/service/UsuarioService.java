package com.sena.autoqa.service;

import com.sena.autoqa.model.Usuario;
import com.sena.autoqa.repository.UsuarioRepository;
import com.sena.autoqa.service.interfaces.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UsuarioService implements CrudService<Usuario, Integer> {

    private final UsuarioRepository usuarioRepository;

    //Inyeccion de dependencias
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Implementacion de metodos CRUD
    @Override
    public Usuario save(Usuario entity) {
        return usuarioRepository.save(entity);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario update(Integer id, Usuario entity) {
        if (!usuarioRepository.existsById(id)) {
            throw new NoSuchElementException("Usuario no encontrado");
        }
        entity.setId(id);
        return usuarioRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new NoSuchElementException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
