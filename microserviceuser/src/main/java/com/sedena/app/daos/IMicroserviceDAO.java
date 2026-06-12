package com.sedena.app.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sedena.app.entities.User;

public interface IMicroserviceDAO extends CrudRepository<User, Long>{
	@Query("SELECT u FROM User u WHERE u.email=:email")
	Optional<User> searchByEmail(@Param("email") String email);
}
