package com.app.resource;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/cookie")
public class CookieParamRsource {

	
	public CookieParamRsource() {
		System.out.println("CookieParamRsource:: Executed");
	}
	
	@GET
	@Path("/set")
	public Response setCookieData() {
		
		NewCookie cookie=new NewCookie("data", "Rituraj");
		NewCookie cookie2=new NewCookie("db","Mysql");
			
			ResponseBuilder builder=Response.ok("<h1>Data Seted From Cookies Thanks...........!!</h1>");
			Response response=builder.cookie(cookie,cookie2).build();
		return response;
	}
	
	@GET
	@Path("/get")
	public String getCookieData(@CookieParam("data") String val,@CookieParam("db") String val1) {
		System.out.println("getCookieData() :: Called");
		System.out.println("Cookie Data Comes: "+val+"......"+val1);
		
		return "Cookie Data ::"+val+"................."+val1;
	}
	
}
