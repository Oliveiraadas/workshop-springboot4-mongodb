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
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
        // 💡 CORREÇÃO: Usa o utilitário URL para decodificar o texto que veio da URL
        text = URL.decodeParam(text);
        
        // Busca a lista de posts que contêm o texto no título
        List<Post> list = service.findByTitle(text);
        
        return ResponseEntity.ok().body(list);
    }

}
