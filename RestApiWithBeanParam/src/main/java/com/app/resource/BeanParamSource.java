package com.app.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.app.model.User;

@Path("/user")
public class BeanParamSource {

	public BeanParamSource() {
		System.out.println("BeanParamSource:: Called..........");
	}
	
	@Path("/save")
	@POST
	public String registerUser(@BeanParam User user) {
		
		System.out.println("registerUser():: called");
		System.out.println(user);
		
		return "Data Is: "+user;
		
	}
}
