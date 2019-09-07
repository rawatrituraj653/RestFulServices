package com.resteasy.resource;

import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/first")
public class MyFirstResource {

	public MyFirstResource() {
		System.out.println("MyFirstResource:: Called");
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response getFirstResponse() {
		System.out.println("getFirstResponse:: Called");
		String msg = "<h1>Welcome to RestEasy Implementation ::Today Date</h1>" + LocalDateTime.now();
		return Response.ok(msg).build();
	}
}
