package com.aluracurso.challengeliteratura;

import com.aluracurso.challengeliteratura.principal.Principal;
import com.aluracurso.challengeliteratura.repository.AutoresRepository;
import com.aluracurso.challengeliteratura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ChallengeliteraturaApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private AutoresRepository autoresRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeliteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroRepository, autoresRepository);
		principal.menu();

	}
}
