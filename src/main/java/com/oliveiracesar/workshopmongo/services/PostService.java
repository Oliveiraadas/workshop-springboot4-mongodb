package com.oliveiracesar.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveiracesar.workshopmongo.domain.Post;
import com.oliveiracesar.workshopmongo.repository.PostRepository;
import com.sun.jdi.ObjectCollectedException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Post user = repo.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectCollectedException("Objeto não enontrado");
		}
		return user;
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
}
