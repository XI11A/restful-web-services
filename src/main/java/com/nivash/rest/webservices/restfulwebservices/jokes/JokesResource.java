package com.nivash.rest.webservices.restfulwebservices.jokes;

import com.nivash.rest.webservices.restfulwebservices.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        Jokes joke = service.findOne(id);
        System.out.println(joke);
        return jokeMethod(joke,id);
    }

    private Jokes jokeMethod(Jokes joke, int id) throws JokesNotFoundException{
        if (joke==null)
            throw new JokesNotFoundException("id="+id);
        return joke;
    }

    @PostMapping("/jokes")
    public ResponseEntity<Object> createJoke(@RequestBody Jokes joke){
        Jokes savedJoke = service.save(joke);

        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedJoke.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/jokes/{id}")
    public void deleteUser(@PathVariable int id){
        Jokes joke = service.deleteById(id);
        if (joke==null)
            throw new JokesNotFoundException("id="+id);
    }

}
