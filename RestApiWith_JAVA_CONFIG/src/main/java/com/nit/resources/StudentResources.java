package com.nit.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nit.model.Student;

@Path("/student")
public class StudentResources {
	
	
	public StudentResources() {
		System.out.println("StudentResources::constructor");
	}

	@GET
	@Path("/data/{sid}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getStudent(@PathParam("sid") Integer sid) {
		Student student=new Student();
		student.setStudentId(sid);
		student.setStudentName("Suraj");
		student.setStudentAge(24);
		student.setStudentGender("MALE");
		student.setStudentFee(40000.00);
		
		return Response.ok(student).build();
	}
}
