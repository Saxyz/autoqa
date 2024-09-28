package com.sena.autoqa;


import com.sena.autoqa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoqaApplication implements CommandLineRunner {
	@Autowired
	UsuarioService usuarioService;

	public AutoqaApplication(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AutoqaApplication.class, args);
	}

	@Override
	public void run(String... args) {

	}
}
