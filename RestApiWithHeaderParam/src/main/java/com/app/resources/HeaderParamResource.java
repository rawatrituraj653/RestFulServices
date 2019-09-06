package com.app.resources;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

@Path("/header")
public class HeaderParamResource {
	
	public HeaderParamResource() {
		System.out.println("HeaderParamResource:: called");
	}

	@GET
	@Path("/data")
	public String getHeader(@HeaderParam("user-agent") String user) {
		System.out.println("getHeader():: called");
		System.out.println(user);
		return user;
	}
	
	@GET
	@Path("/head")
	public String getAllHeaders(@Context HttpHeaders header) {
		
		MultivaluedMap map= header.getRequestHeaders();
		Set<String> allheaders= map.keySet();
		for (String head : allheaders) {
			System.out.println("All Keys ::"+head);
			List headerValue=header.getRequestHeader(head);
			System.out.println(headerValue);
			System.out.println("====================================================");
		}		
		return "Information Comming In server Console";
	}
	
	
}
