package com.webapp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.webapp.hotel.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.username = :username")
	public User findUserByUsername(@Param("username") String username); 
	
}