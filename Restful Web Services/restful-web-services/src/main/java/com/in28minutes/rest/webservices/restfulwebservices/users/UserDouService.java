package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDouService {
	private static List<User> users = new ArrayList<User>();

	private static int userCount = 3;
	static {
		users.add(new User(1, "Yagna", new Date()));
		users.add(new User(2, "Rahul", new Date()));
		users.add(new User(3, "Bhaskar", new Date()));
	}

	// findall
	public List<User> findAll() {
		return users;
	}

	// save
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	// findOne
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	// DeleteUser
	public User deletebyUserId(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
