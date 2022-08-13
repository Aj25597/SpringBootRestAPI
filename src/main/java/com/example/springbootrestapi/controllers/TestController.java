package com.example.springbootrestapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springbootrestapi.models.*;
import java.util.*;
import org.springframework.web.bind.annotation.RequestBody;




//Makes program function as a rest controller
@RestController
public class TestController {
    
@GetMapping(value = "/health") 
public String healthCheck() {
    return "I am healthy!!";
}    

//Return Instance of a person
@GetMapping(value="/person")
public Person getPerson() {
    return new Person(1,"AJ","UMD",20);
}


@GetMapping(value="/people")
public ArrayList<Person> getPeople() {

    ArrayList<Person> people = new ArrayList<>();

    Person AJ = new Person(1,"AJ","UMD",20);
    Person Bob = new Person(2, "Bob", "UNC", 2);
    Person Sydney = new Person(3,"Sydney","Duke", 25);
    Person Timmy = new Person(4,"Timmy","Berklee", 19);

    people.add(AJ);
    people.add(Sydney);
    people.add(Timmy);
    people.add(Bob);

    return people;
}
//echo?term=<String term>
@GetMapping(value="/echo") 
public String getEcho(@RequestParam String term) {
    return String.format("You said %s", term);
}


@PostMapping("/sum")
public SumResponse getSum(@RequestBody SumResponse payload) {
    payload.calculateSum();
    return payload;
}


//Get ID from user, call API to return pokemon by ID
//{id} = path parameter. QS and Path Parameter are ways to pass info to API

@ResponseBody
@GetMapping("/pokemon/{id}")
public Pokemon fetchPokemon(@PathVariable String id) {
    
    String url = String.format("https://pokeapi.co/api/v2/pokemon/%s", id);
    
    //Used when a call has potential to fail. Handles errors during calls
    RestTemplate restTemplate = new RestTemplate();
    Pokemon pokemon = restTemplate.getForObject(url, Pokemon.class);


    return pokemon;



}

@ResponseBody
@GetMapping("/pokemonItem/{id}")
public PokemonItem getPokemonItem(@PathVariable String id) {
    String url = String.format("https://pokeapi.co/api/v2/item/%s", id);

    System.out.println(url);
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, PokemonItem.class);

   

}



}










