package com.nit.resources;

import java.time.LocalDateTime;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/greet")
@Singleton
public class GreetResource {
	
	public GreetResource() {
		System.out.println("GreetResource::Constructor");
	}

	@GET
	@Path("/msg")
	public Response getMsg() {
		String msg="<h1>HEllO, Sir::</h1>"+"<h2>Today Date IS::"+LocalDateTime.now()+"</h2>"; 
		return Response.ok(msg).build();
	}

}
