package com.sena.autoqa;

import com.sena.autoqa.model.Usuario;
import com.sena.autoqa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoqaApplication implements CommandLineRunner {

	@Autowired
	UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(AutoqaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Usuario usuario1 = new Usuario(null, "pepa pig polo", "pepewow@gmail.com",
				"1309tilin", "11");
		usuarioService.save(usuario1);
		//usuarioService.update(9, usuario1);

		System.out.println("Usuario guardado");
		System.out.println("Mostrar usuarios guardados");
		usuarioService.findAll().forEach(usuario -> System.out.println(usuario.toString()));


	}
}
