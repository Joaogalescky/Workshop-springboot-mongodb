package com.joaogalescky.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joaogalescky.workshopmongo.domain.Post;
import com.joaogalescky.workshopmongo.domain.User;
import com.joaogalescky.workshopmongo.dto.AuthorDTO;
import com.joaogalescky.workshopmongo.repository.PostRepository;
import com.joaogalescky.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postReposiroty;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postReposiroty.deleteAll();

		User maria = new User(null, "Maria Silva", "maria@gmail.com");
		User matheus = new User(null, "Matheus Santos", "matheus@ymail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, matheus, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		postReposiroty.saveAll(Arrays.asList(post1, post2));
	}
}
