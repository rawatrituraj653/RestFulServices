package com.universal.resource;

import java.util.List;
import java.util.Set;

import javax.inject.Singleton;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/customer")
@Singleton/* to make our root resource class as a singleton*/
public class CustomerResourceWithQuery {

	public CustomerResourceWithQuery() {
		System.out.println("CustomerResourceWithQuery:: executed");
	}
	
	@GET
	@Path("/one")
	public String  getCustomerName(@QueryParam("cid") String customerId) {
		System.out.println("getCustomerName() called");
		System.out.println("Cusomer Id:"+customerId);
		return "Customer Name is Rituraj And Age is 22";
	}
	@GET
	@Path("/data")
	public String getCustomers(@DefaultValue("AM123IT") @QueryParam("cid") String id,@DefaultValue("Amit") @QueryParam("name") String name) {
		System.out.println("getCustomers() called");
		System.out.println("Customer Id is "+id);
		System.out.println("CustomerName is "+name);
		return "<h2>Customer:: Salary Is :30000 And Dept IS: 30<h2>";
		}
	
	@GET
	@Path("ids")
	public String getNames(@Context UriInfo info) {

		MultivaluedMap<String,String> map=info.getQueryParameters();
		List<String> list=map.get("id");
		Set<String> set=map.keySet();
		System.out.println("==========All Keys===========");
		set.forEach(System.out::println);
		System.out.println("==========All values==========");
		list.forEach(System.out::println);
		return "Employee Name is: John,Smit,AMit,MAhesh";
	}
}
