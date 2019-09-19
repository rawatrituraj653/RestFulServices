package com.app.client;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.app.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestEasyPostClient {

	public static void main(String[] args) throws Exception {
		ClientRequest request=new ClientRequest("http://localhost:8085/Rest_api_with_Crud_Operation/rest/book/save");
		Book book=new  Book();
		book.setBookIsbn("MATHEM12");
		book.setBookName("Mathematics");
		book.setBookAuthor("RS Agrawal");
		book.setBookPrice(500.00);
		book.setRelDate(new Date());
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(book);
		request.body(MediaType.APPLICATION_JSON, json);
		ClientResponse<String> clientResponse=request.post(String.class);
		int status=clientResponse.getStatus();
		if(status==200) {
			System.out.println(clientResponse.getEntity());
		}
		
	}
}
