package com.tony.code.back_end.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tony.code.back_end.dao.PersonRepository;
import com.tony.code.back_end.entities.Person;


@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	private ArrayList<Person> myArrayList;

	@GetMapping("/person")
	public ArrayList<Person> getAllPeople() {

		myArrayList = (ArrayList<Person>) personRepository.findAll();

		return myArrayList;
	}

	@PostMapping("/addPerson")
	public void addPerson(@RequestBody Person person) {

		personRepository.save(person);
	}
	
	
}
