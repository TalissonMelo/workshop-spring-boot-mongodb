package com.talissonMelo.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.talissonMelo.workshop.domain.Post;
import com.talissonMelo.workshop.domain.User;
import com.talissonMelo.workshop.dto.AuthorDTO;
import com.talissonMelo.workshop.repository.PostRepository;
import com.talissonMelo.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		Post p1 = new Post(null, sdf.parse("21/02/2019"), "Partiu Viagem", "Vou viajar para São paulo. Bjs",
				new AuthorDTO(u1));
		Post p2 = new Post(null, sdf.parse("21/12/2019"), "Dia especial", "Parabéns pelo dia!.", new AuthorDTO(u1));

		postRepository.saveAll(Arrays.asList(p1, p2));

		u1.getPosts().addAll(Arrays.asList(p1, p2));
		userRepository.save(u1);
	}

}
