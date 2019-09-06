package com.nit.resource;

import java.util.Arrays;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.nit.resource.model.Employee;

@Path(value ="/welcome") 
public class WishResource {

	
	public WishResource() {
		System.out.println("WishResource():: Executed");
	}
	
	
	@GET
	@Path("/wish")
	public String wishUser() {
		return "<h1>Welcome to RestFul servcies.....!!</h1>";		
	}

	@GET
	@Path("/all")
	public String getEmp(){
		return Arrays.asList(
			new Employee(101, "rituraj", 40000.00),
			new Employee(102, "pavan", 32000.00),
			new Employee(103, "Amit", 48000.00),
			new Employee(104, "suraj", 53000.00)
			).toString();	
	}
	
	@GET
	@Path("/one")
	public String getOne() {
		return new Employee(104, "suraj", 53000.00).toString(); 
	}
	
}
