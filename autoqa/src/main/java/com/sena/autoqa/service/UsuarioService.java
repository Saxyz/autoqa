package com.sena.autoqa.service;

import com.sena.autoqa.model.Usuario;
import com.sena.autoqa.repository.UsuarioRepository;
import com.sena.autoqa.service.interfaces.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.isEmpty() ? Collections.emptyList() : usuarios;
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("No se encontró el usuario"));
    }

    @Override
    public Usuario update(Integer id, Usuario entity) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("No se encontró el usuario"));

        if (entity.getNombre()!=null){
            usuario.setNombre(entity.getNombre());
        }
        if (entity.getContrasenia()!=null){
            usuario.setContrasenia(entity.getContrasenia());
        }
        if (entity.getCorreo()!=null){
            usuario.setCorreo(entity.getCorreo());
        }
        if (entity.getTokenJira()!=null){
            usuario.setTokenJira(entity.getTokenJira());
        }
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public boolean deleteById(Integer id) {
        boolean flag = false;
        if (!usuarioRepository.existsById(id)) {
            throw new NoSuchElementException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
        flag = true;
        return flag;
    }
}
