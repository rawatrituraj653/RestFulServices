package com.universal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/book")
public class BookStore {

	public BookStore() {
		System.out.println("BookStore Class Object Is created");
	}
	
	@GET
	@Path("/{isbn}")
	public String getBookPrice(@PathParam("isbn") String isbn) {
		System.out.println("getBookPrice() Called \n"+isbn);
		return "Price is ::3000";
	}
	
	@GET
	@Path("/one/{isbn}/{name}")
	public String getOneBook(@PathParam("isbn") String isbn ,@PathParam("name") String name) {
		System.out.println("getOneBook() called");
		System.out.println(isbn+"....................."+name);
		return "<h1>This is more costly than others</h1>::"+"Price ::10000000$";
	}
}
