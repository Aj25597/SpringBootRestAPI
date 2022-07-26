package com.example.springbootrestapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootrestapi.models.*;
import java.util.*;



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




}


