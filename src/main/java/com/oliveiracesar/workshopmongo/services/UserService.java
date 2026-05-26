package com.oliveiracesar.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveiracesar.workshopmongo.domain.User;
import com.oliveiracesar.workshopmongo.repository.UserRepository;
import com.sun.jdi.ObjectCollectedException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {

		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectCollectedException("Objeto não enontrado");
		}
		return user;
	}
}
