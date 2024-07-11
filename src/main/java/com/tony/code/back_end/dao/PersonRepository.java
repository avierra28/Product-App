package com.tony.code.back_end.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tony.code.back_end.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
