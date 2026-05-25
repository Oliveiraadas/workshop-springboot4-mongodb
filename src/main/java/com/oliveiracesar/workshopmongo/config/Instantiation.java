package com.oliveiracesar.workshopmongo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.oliveiracesar.workshopmongo.domain.User;
import com.oliveiracesar.workshopmongo.repository.UserRepository;

@Component
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		// Limpa a coleção no banco antes de inserir
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com"); 
		
		// Usando List.of para garantir a compatibilidade do Spring Data
		userRepository.saveAll(List.of(maria, alex, bob));
		
		System.out.println("Carga de dados executada com sucesso!");
	}
}
