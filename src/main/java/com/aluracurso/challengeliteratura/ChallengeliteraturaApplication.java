package com.aluracurso.challengeliteratura;

import com.aluracurso.challengeliteratura.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeliteraturaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeliteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.menu();

	}
}
