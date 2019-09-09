package com.nit.resources;

import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/get")
public class GreetResource {
	
	public GreetResource() {
		System.out.println("GreetResource::Constructor");
	}

	@GET
	public Response getMsg() {
		String msg="<h1>HEllO, Sir::</h1>"+"<h2>Today Date IS::"+LocalDateTime.now()+"</h2>"; 
		return Response.ok(msg).build();
	}
}
