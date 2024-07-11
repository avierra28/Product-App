package com.tony.code.back_end.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personid")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email_address")
	private String email_address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email_address=" + email_address + "]";
	}

	public Person(Long id, String name, String email_address) {
		super();
		this.id = id;
		this.name = name;
		this.email_address = email_address;
	}

	public Person() {
		super();
	}

}
