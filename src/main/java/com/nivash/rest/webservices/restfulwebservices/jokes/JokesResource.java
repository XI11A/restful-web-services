package com.nivash.rest.webservices.restfulwebservices.jokes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JokesResource {

    @Autowired private JokesDaoService service;

    @GetMapping("/jokes")
    public List<Jokes> retrieveAllJokes(){
        return service.findAll();
    }

    @GetMapping("/jokes/{id}")
    public Jokes retrieveJoke(@PathVariable int id){
        Jokes jokes = findOne();
    }

}
