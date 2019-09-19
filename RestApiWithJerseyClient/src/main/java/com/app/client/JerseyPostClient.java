package com.app.client;

import java.util.Date;

import com.app.model.Book;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyPostClient {

	public static void main(String[] args) {
		
		Client client=Client.create();
		WebResource resource=client.resource("http://localhost:8085/Rest_api_with_Crud_Operation/rest/book/save");
		resource.header("Content-Type", "application/json");
		Book book=new Book();
		book.setBookIsbn("HIBNER");
		book.setBookName("HIbernate");
		book.setBookAuthor("GavenKing");
		book.setBookPrice(300.00);
		book.setRelDate(new Date());
		ClientResponse response=resource.post(ClientResponse.class, book);
		int status =response.getStatus();
		if(status==200) {
			String str=response.getEntity(String.class);
			System.out.println(str);
		}
		else {
			System.out.println("Server Side Try After Some Time");
		}
		
	}
}
