package com.sedena.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //esta clase será una tabla
@Table(name="users") //se utiliza para modificar la tabla
public class User {
	@Id //el atributo id será un pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private long id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=100)
	private String surname;
	
	@Column(length=150)
	private String email;
	
	@Column(length=200)
	private String address;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
}