package com.app.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.app.model.Customer;

@Provider
public class CustomerMessageWriter implements MessageBodyWriter<Customer>{

	public CustomerMessageWriter() {
		System.out.println("CustomerMessageWriter:: Executed");
	}
	
	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		System.out.println("isWriteable()  is called");
		return true;
	}

	@Override
	public long getSize(Customer t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		System.out.println("getSize():: called");
		return  300;
	}

	@Override
	public void writeTo(Customer t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		System.out.println("writeTo():: called");
		OutputStreamWriter outputStreamWriter=new  OutputStreamWriter(entityStream);
		Writer writer=new PrintWriter(outputStreamWriter);
			writer.write("Customer Id: "+t.getCustId()+"<br>");
			writer.write("Customer Name: "+t.getCustName()+"<br>");
			writer.write("Customer Email: "+t.getEmail()+"<br>");
			writer.write("Customer Amount: "+t.getAmount()+"<br>");
		
			writer.flush();
			writer.close();
	}

}
