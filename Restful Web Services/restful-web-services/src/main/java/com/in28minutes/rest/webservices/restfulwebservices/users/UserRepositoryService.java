package com.in28minutes.rest.webservices.restfulwebservices.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepositoryService extends JpaRepository<User, Integer> {

}
