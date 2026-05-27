package com.oliveiracesar.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.oliveiracesar.workshopmongo.domain.Post;
import com.oliveiracesar.workshopmongo.domain.User;
import com.oliveiracesar.workshopmongo.dto.AuthorDTO;
import com.oliveiracesar.workshopmongo.repository.PostRepository;
import com.oliveiracesar.workshopmongo.repository.UserRepository;

@Component
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com"); 
		
		userRepository.saveAll(List.of(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou para SP abraço",new AuthorDTO( maria));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia" ,"Acordei feliz hoje", new AuthorDTO(maria));
		

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		System.out.println("Carga de dados executada com sucesso!");
	}
}

