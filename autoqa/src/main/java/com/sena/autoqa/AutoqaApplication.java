package com.sena.autoqa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import com.sena.autoqa.service.UsuarioService;

@SpringBootApplication
public class AutoqaApplication implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    public static void main(String[] args) {
        SpringApplication.run(AutoqaApplication.class, args);
    }

    @Override
    @Profile("dev")
    public void run(String... args) throws Exception {

        // Usuario usuario1 = new Usuario(null, "Juancho Polo", "sech@gmail.com", "1309tilin", "1111");
        // usuarioService.save(usuario1);

        // System.out.println("Usuario guardado");
        System.out.println("Proyecto corriendo");
        usuarioService.findAll().forEach(usuario -> System.out.println(usuario.toString()));
    }
}
