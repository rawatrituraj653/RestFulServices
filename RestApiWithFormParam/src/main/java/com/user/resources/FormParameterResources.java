package com.user.resources;

import java.util.UUID;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class FormParameterResources {

	@POST
	@Path("/reg")
	public String getData(@FormParam ("uname") String uname,
						@FormParam ("pwd") String pwd,
						@FormParam("email") String email
			) {
			
		System.out.println("getData()::called");
		System.out.println("UserName ::"+uname);
		System.out.println("Password ::"+pwd);
		System.out.println("Email::"+email);

		return "User Registration Succesfully WithId:"
		+UUID.randomUUID().toString().toUpperCase().substring(0,8).toString();
	}
	
}
