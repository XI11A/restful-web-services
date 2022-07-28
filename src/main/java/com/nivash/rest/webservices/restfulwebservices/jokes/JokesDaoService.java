package com.nivash.rest.webservices.restfulwebservices.jokes;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JokesDaoService {

    private static List<Jokes> jokes = new ArrayList<>();

    private static int jokesCount = 521;

    public void jokesResourceFile() throws IOException {
        File resource = new ClassPathResource("jokes.json").getFile();
        String jokes = new String(Files.readAllBytes(resource.toPath()));

    }

    public List<Jokes> findAll(){
        return jokes;
    }

    public Jokes save(Jokes joke){
        if (joke.getId()==null){
            joke.setId(++jokesCount);
        }
        jokes.add(joke);
        return joke;
    }

    public Jokes findOne(int id){
        for (Jokes joke:jokes){
            if (joke.getId()==id){
                return joke;
            }
        }
        return null;
    }
    public Jokes deleteById(int id){
        Iterator<Jokes> iterator = jokes.iterator();
        while (iterator.hasNext()){
            Jokes jokes = iterator.next();
        }
        for (Jokes joke:jokes){
            if (joke.getId()==id){
                iterator.remove();
                return joke;
            }
        }
        return null;
    }
}
