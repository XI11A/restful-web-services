package com.nivash.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;
    //GET /users
    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    //GET /users/{id}
    //retrieveUser(int id)
    @GetMapping("/users/{id}")
    public User retrieveUser (@PathVariable int id){
        User user = service.findOne(id);
        System.out.println(user);
       return userMethod(user,id);
    }
    public static User userMethod (User user, int id) throws UserNotFoundException{
        if (user==null)
            throw new UserNotFoundException("id-"+id+" Not Found");
        return user;
    }

    //POST /users
    //Input - User Details
    //Output - Created & Return the created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        //CREATED
        // /user/{id}
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser (@PathVariable int id){
        User user = service.deleteByID(id);

        if (user==null)
            throw new UserNotFoundException("id-"+id+" Not Found");
    }

}
