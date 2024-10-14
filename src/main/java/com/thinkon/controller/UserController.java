package com.thinkon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkon.entity.User;
import com.thinkon.exception.UserNotFoundException;
import com.thinkon.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController{
	
	@Autowired
	UserService userService;
	
	    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public User createUser(@RequestBody User user) {
	        return userService.createUser(user);
	    }

	    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<User>  getAllUsers() {
	        return userService.getAllUsers();
	    }

	    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public User getUserById(@PathVariable Long id) {
	        return userService.getUserById(id);
	    }

	    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
	        return userService.updateUser(id, updatedUser);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	        return ResponseEntity.noContent().build();
	    }

	    @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}
    



