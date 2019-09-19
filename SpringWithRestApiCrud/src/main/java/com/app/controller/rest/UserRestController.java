package com.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.app.model.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private IUserService  service;
	
	@PostMapping(value="/save",consumes = {"application/json","application/xml"})
	public ResponseEntity<String> saveUser(@RequestBody User user){
	ResponseEntity<String> entity=null;	
	Integer userId=	service.saveUser(user);
	if(userId>=1) {
		entity=new ResponseEntity<String>("User Saved Successfully...Id::"+userId,HttpStatus.OK);
	}
	else {
		entity=new ResponseEntity<String>("Some Problem Occured..",HttpStatus.BAD_REQUEST);
	}
	return entity;
	
	}
	
	@GetMapping(value="/find/{id}",produces = {"application/json","application/xml"})
	public ResponseEntity<?> getUser(@PathVariable Integer id){
		ResponseEntity<?> entity=null;
		User user=service.findUserById(id);
		if(null!=user) {
			entity=new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else {
			entity=new ResponseEntity<String>("User Not Found...!!",HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@GetMapping(value="/findAll",produces = {"application/json","application/xml"})
	public ResponseEntity<List<User>> getAll(){
		
		List<User> list=service.findAllUser();
		ResponseEntity<List<User>> entity=new ResponseEntity<List<User>>(list,HttpStatus.OK);
		return entity;
	}
	@PutMapping(value="/update",consumes = {"application/json","application/xml"})
	public ResponseEntity<String> updateUser(@RequestBody User user){
		ResponseEntity<String> entity=null;
		service.updateUser(user);
		entity=new ResponseEntity<String>("User Data Updated Sucessfully...!!",HttpStatus.OK);
		return entity;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		User user=new User();
		user.setUserId(id);
			service.deleteUser(user);
		return new ResponseEntity<String>("User Data Deleted From Db..!!",HttpStatus.OK);
	}
	
	
	
}

