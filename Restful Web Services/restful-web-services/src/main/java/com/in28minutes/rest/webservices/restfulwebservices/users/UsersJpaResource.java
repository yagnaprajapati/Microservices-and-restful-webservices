package com.in28minutes.rest.webservices.restfulwebservices.users;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UsersJpaResource {

	@Autowired
	protected UserDouService service;
	// retrieve all users
	@Autowired
	private UserRepositoryService repositoryService;
	@Autowired
	private PostRepository postrepository;

	@GetMapping("/jpa/users")
	public List<User> retrieveAllusers() {
		return repositoryService.findAll();

	}

	// retrieve User id
	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveUserId(@PathVariable int id) {
		Optional<User> user = repositoryService.findById(id);
		if (!user.isPresent())
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

	@DeleteMapping("/jpa/users/{id}")
	public void DeleteUserbyId(@PathVariable int id) {
		repositoryService.deleteById(id);

	}

	// create
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> create(@Valid @RequestBody User user) {
		// create
		User savedUser = repositoryService.save(user);
		// Create location status 201
		// /users/{id} /savedUser.getid()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).body(savedUser);
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveUserPost(@PathVariable int id) {
		Optional<User> userOptional = repositoryService.findById(id);
		if (!userOptional.isPresent())
			throw new UserNotFoundException("id-" + id);

		// HATEOAS

		return userOptional.get().getPosts();
		// return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@Valid @PathVariable int id, @RequestBody Post post) {

		Optional<User> userOptional = repositoryService.findById(id);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		User user = userOptional.get();

		post.setUser(user);

		postrepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
