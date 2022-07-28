package com.nivash.rest.webservices.restfulwebservices.jokes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JokesNotFoundException extends RuntimeException{
    public JokesNotFoundException(String message) {super(message);}
}
