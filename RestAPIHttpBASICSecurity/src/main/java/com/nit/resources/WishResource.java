package com.nit.resources;

import java.time.LocalDateTime;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/wish")
@Singleton
public class WishResource {

	
	public WishResource() {
		System.out.println("WishResource:: constructor");
	}
	
	@GET
	@Path("/msg")
	public Response getMsg() {
		System.out.println("getMsg :: called");
		String msg="<h1>This is comes from Secured Resources::"+LocalDateTime.now()+"</h1>";
		return Response.ok(msg).build();
	}
}
