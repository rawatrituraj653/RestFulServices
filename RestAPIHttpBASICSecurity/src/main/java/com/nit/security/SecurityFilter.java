package com.nit.security;

import java.io.IOException;
import java.util.Base64;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityFilter implements ContainerRequestFilter{

	private String msg="Authentication Failed send valid USERNAME and PASSWORD.To process Request..!!";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String auth=requestContext.getHeaderString("Authorization");
		if(auth!=null && !auth.equals("")) {
			auth=auth.replace("Basic ", "");
			byte[] arr=Base64.getDecoder().decode(auth);
			String unameAndPwd=new String (arr);
			String [] data=unameAndPwd.split(":");
			String user=data[0];
			String pwd=data[1];
			if("ABCD".equals(user) && "ABCD123@".equals(pwd)) {
				return;
			}
			else {
				Response response=Response.status(Status.UNAUTHORIZED).entity(msg).build();
				requestContext.abortWith(response);
			}
		}
		Response response=Response.status(Status.BAD_REQUEST).entity(msg).build();
		requestContext.abortWith(response);
	}
}
