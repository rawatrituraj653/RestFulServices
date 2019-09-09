package com.st.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/emp")
public class EmpProvider {

	@GET
	@Path("/msg")
	public String showmsg() {
		return "hello";
	}
}
