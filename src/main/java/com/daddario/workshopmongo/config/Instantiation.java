package com.daddario.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.daddario.workshopmongo.domain.Post;
import com.daddario.workshopmongo.domain.User;
import com.daddario.workshopmongo.repository.PostRepository;
import com.daddario.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null,"Maria Brown","maria@gmail.com");
		User alex = new User(null,"Alex Green","alex@gmail.com");
		User bob = new User (null,"Bob Grey","bob@gmail.com");

		userRepo.deleteAll();
		userRepo.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu Viagem","Vou viajar para São Paulo. Abraços!",maria);
		Post post2 = new Post(null,sdf.parse("23/03/2018"),"Bom dia","Acordei feliz hoje!",maria);
		
		postRepo.deleteAll();
		postRepo.saveAll(Arrays.asList(post1,post2));
				
	}

}
