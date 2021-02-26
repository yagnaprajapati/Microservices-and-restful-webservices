package com.in28minutes.rest.webservices.restfulwebservices.users;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {

	@Autowired
	protected UserDouService service;
	// retrieve all users

	@GetMapping("/users")
	public List<User> retrieveAllusers() {
		return service.findAll();

	}

	// retrieve User id
	@GetMapping("/users/{id}")
	public User retrieveUserId(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
 

		// HATEOAS

		return user;
		// return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	/*
	 * @GetMapping("/users/{id}") public EntityModel<User>
	 * retrieveUser(@PathVariable int id) { User user = service.findOne(id);
	 * 
	 * if(user==null) throw new UserNotFoundException("id-"+ id);
	 * 
	 * 
	 * //"all-users", SERVER_PATH + "/users" //retrieveAllUsers EntityModel<User>
	 * resource = EntityModel.of(user);
	 * 
	 * WebMvcLinkBuilder linkTo =
	 * linkTo(methodOn(this.getClass()).retrieveAllusers());
	 * 
	 * resource.add(linkTo.withRel("all-users"));
	 * 
	 * //HATEOAS
	 * 
	 * return resource; }
	 */

	@DeleteMapping("/users/{id}")
	public void DeleteUserbyId(@PathVariable int id) {
		User user = service.deletebyUserId(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
	}

	// create
	@PostMapping("/users")
	public ResponseEntity<Object> create(@Valid @RequestBody User user) {
		// create
		User savedUser = service.save(user);
		// Create location status 201
		// /users/{id} /savedUser.getid()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).body(savedUser);
	}
}
