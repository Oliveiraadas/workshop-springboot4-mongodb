package com.oliveiracesar.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiracesar.workshopmongo.domain.Post;
import com.oliveiracesar.workshopmongo.resources.util.URL;
import com.oliveiracesar.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

		text = URL.decodeParam(text);

		List<Post> list = service.findByTitle(text);

		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

		text = com.oliveiracesar.workshopmongo.resources.util.URL.decodeParam(text);

	
		java.util.Date min = com.oliveiracesar.workshopmongo.resources.util.URL.convertDate(minDate,
				new java.util.Date(0));
		java.util.Date max = com.oliveiracesar.workshopmongo.resources.util.URL.convertDate(maxDate,
				new java.util.Date());

		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}

}
