package com.st.ser;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/otp")
public class OtpServlet {
	
	@GET
	public	String generateOtp() {
		return UUID.randomUUID().toString().substring(0, 6).toUpperCase();
	}
}
