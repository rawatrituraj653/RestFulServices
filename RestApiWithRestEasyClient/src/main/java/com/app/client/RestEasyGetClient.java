package com.app.client;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class RestEasyGetClient {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("deprecation")
		ClientRequest request=new ClientRequest("http://localhost:8085/Rest_api_with_Crud_Operation/rest/book/find");
		request.accept(MediaType.APPLICATION_JSON);
		ClientResponse<String> response=request.get(String.class);
		int status =response.getStatus();
		if(status==200) {
			System.out.println(response.getEntity());
		}
	}
}
