package com.app.rest;

import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/car")
public class MatrixParamSource {

	@GET
	@Path("type/{name}/{model}")
	@Produces(MediaType.TEXT_HTML)
	public String getMatrix(@PathParam("name")String name,@PathParam("model") String model,@MatrixParam("color")String color) {
		System.out.println("Car Name::"+name);
		System.out.println("Car Model::"+model);
		System.out.println("Car Color::"+color);	
		return "This is Data Comes TOday::<h1>"+LocalDateTime.now()+"</h1>";
	}
}
