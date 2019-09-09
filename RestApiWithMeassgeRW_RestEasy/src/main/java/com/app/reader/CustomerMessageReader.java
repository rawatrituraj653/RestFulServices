package com.app.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.app.model.Customer;

@Provider
public class CustomerMessageReader implements MessageBodyReader<Customer>{

	public CustomerMessageReader() {
		System.out.println("CustomerMessageReader:: Executed");
	}
	
	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		System.out.println("isReadable is called");
		return true;
	}

	@Override
	public Customer readFrom(Class<Customer> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		System.out.println("read From Called");
			InputStreamReader  reader=new InputStreamReader(entityStream);
			BufferedReader reader2=new BufferedReader(reader);
			String cid=reader2.readLine();
			String cName=reader2.readLine();
			String email=reader2.readLine();
			String cost=reader2.readLine();
			
			Customer c=new Customer();
			
			c.setCustId(Integer.parseInt(cid));
			c.setCustName(cName);
			c.setEmail(email);
			c.setAmount(Double.parseDouble(cost));
		return c;
	}

	
	
}
