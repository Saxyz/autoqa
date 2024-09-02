package com.sena.autoqa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.autoqa.exception.ResourceNotFoundException;
import com.sena.autoqa.model.Usuario;
import com.sena.autoqa.repository.UsuarioRepository;
import com.sena.autoqa.service.interfaces.CrudService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@Service
public class UsuarioService implements CrudService<Usuario, Integer> {

    private final UsuarioRepository usuarioRepository;

    // Inyección de dependencias
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Implementación de métodos CRUD
    @Override
    public Usuario save(@Valid Usuario entity) {
        validateUsuario(entity);
        return usuarioRepository.save(entity);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
    }

    @Override
    public Usuario update(Integer id, @Valid Usuario entity) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con id: " + id);
        }
        entity.setId(id);
        validateUsuario(entity);
        return usuarioRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    // Método para validar el objeto Usuario según las reglas de negocio
    private void validateUsuario(Usuario usuario) {
        // Ejemplo de validación para evitar ñ y tildes en el correo
        if (!usuario.getCorreo().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new ValidationException("El correo no debe contener ñ o tildes.");
        }
        
    }
}
