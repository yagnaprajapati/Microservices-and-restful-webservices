package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


@Entity
//@ApiModel(description = "This is the details about the user.")
public class User {

	@Size(min = 2, message = "Name should have atleast two characters. ")
	//@ApiModelProperty(notes = "Name should have atleast two characters.")
	private String name;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Past
	//@ApiModelProperty(notes = "Date should be in the past.")
	private Date birthDate;
	@OneToMany(mappedBy = "user")
	private List<Post>posts;

	public User() {

	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [ id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
