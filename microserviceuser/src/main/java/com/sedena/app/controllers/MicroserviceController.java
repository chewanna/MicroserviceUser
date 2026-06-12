package com.sedena.app.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sedena.app.entities.User;
import com.sedena.app.services.IService;

@RestController //API Restful (json)
@RequestMapping("/user") //http://ip:port/user
public class MicroserviceController {
	private IService service;
	public MicroserviceController(IService service) {
		this.service=service;
	}
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody User u){
		try{
			if(service.insert(u)) {
				return new ResponseEntity<String>("inserted",HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<String>("revisa request",HttpStatus.BAD_REQUEST);
			}
		}catch(Exception ex) {
			return new ResponseEntity<String>("error en server",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	@GetMapping("/{email}")//http://ip:port/user/email
	public ResponseEntity<User> searchByEmail(@PathVariable("email") String email){
		try {
			return new ResponseEntity<>(service.selectByEmail(email),HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping
	public ResponseEntity<List<User>> selectAll(){
		try {
			return new ResponseEntity<>(service.selectAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping
	public ResponseEntity<String> update(@RequestBody User u){
		try {
			if(service.updateById(u))
				return new ResponseEntity<>("actualizado",HttpStatus.OK);
			else
				return new ResponseEntity<>("revisa request",HttpStatus.BAD_REQUEST);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		try {
			if(service.deleteById(id))
				return new ResponseEntity<>("eliminado",HttpStatus.OK);
			else
				return new ResponseEntity<>("revisa solicitudt",HttpStatus.BAD_REQUEST);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}