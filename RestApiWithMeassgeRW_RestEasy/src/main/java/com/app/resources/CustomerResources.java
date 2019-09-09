package com.app.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.app.model.Customer;



@Path("/cust")
public class CustomerResources {

	public CustomerResources() {
		System.out.println("CustomerResources:: Executed");
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_HTML)
	public Response getData() {
		Customer c=new Customer();
		c.setCustId(101);
		c.setCustName("AMit");
		c.setEmail("Amit@gmail.com");
		c.setAmount(40000.00);
		return Response.ok(c).build();
	}
	@POST
	@Path("/save")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response saveData(Customer customer) {
		return Response.ok("Customer Data Added::"+customer).build();
		
	}

	
}
