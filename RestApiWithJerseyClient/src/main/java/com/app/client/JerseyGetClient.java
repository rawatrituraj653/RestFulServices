package com.app.client;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.app.model.Book;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyGetClient {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		Client client=Client.create();
		WebResource  resource=client.resource("http://localhost:8085/Rest_api_with_Crud_Operation/rest/book/find");
		resource.accept(MediaType.APPLICATION_JSON);
		ClientResponse response=resource.get(ClientResponse.class);
		int status=response.getStatus();
		System.out.println(status);
		if(status==200) {
			/*
			 * String book= response.getEntity(String.class); System.out.println(book);
			 * ObjectMapper mapper=new ObjectMapper(); Book book2=mapper.readValue(book,
			 * Book.class); System.out.println(book2);
			 */
			Book book=response.getEntity(Book.class);
			System.out.println(book);
		}
		else {
			System.out.println("Exception in server side Try Again...!!");
		}
		
	}
}
