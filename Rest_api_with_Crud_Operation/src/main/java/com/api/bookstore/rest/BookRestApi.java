package com.api.bookstore.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.api.bookstore.domain.Book;
import com.sun.jersey.spi.resource.Singleton;

@Path("/book")
@Singleton
public class BookRestApi {

	
	public BookRestApi() {
			System.out.println("BookRestApi:: Executed");
	}
	
	
	@GET
	@Path("/find")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Book findbook() throws ParseException {
		System.out.println("findbook() ::called");
		String rd="2002-08-23";
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date =dateFormat.parse(rd);
		System.out.println(date);
		
		Book book=new Book();
		book.setBookIsbn("SPR123EE");
		book.setBookName("Spring Boot");
		book.setBookAuthor("Ashok sir");
		book.setBookPrice(450.00);
		book.setRelDate(date);
		return book;
	}
	
	@POST
	@Path("/save")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public String saveBook(Book book) {
		System.out.println("saveBook():: called");
		System.out.println(book);
		return "Book Data Saved Successfully";
	}
	
	@PUT
	public String updateBook() {
		
		return "Book Data updated successfully..................";
	}
	@DELETE
	public String deleteBook() {
		
		return "Book Updated Successfully......";
	}
}
