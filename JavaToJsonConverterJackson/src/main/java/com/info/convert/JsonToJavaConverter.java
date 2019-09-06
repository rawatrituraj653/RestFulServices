package com.info.convert;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.info.Customer;

public class JsonToJavaConverter {

	public static void main(String[] args) throws Exception{
		
		jsonToCustomer();
		jsonToCustomers();
		
		
		
	}

	private static void jsonToCustomers() throws IOException, JsonParseException, JsonMappingException {
		File file=new File("customers.json");
		ObjectMapper mapper=new ObjectMapper();
		Customer [] customers= mapper.readValue(file,Customer[].class);
		Stream<Customer> stream=Stream.of(customers);
		stream.forEach(System.out::println);
	}

	public  static void jsonToCustomer() throws IOException, JsonParseException, JsonMappingException {
		File src=new File("customer.json");
		ObjectMapper  mapper=new ObjectMapper();
		Customer customer=mapper.readValue(src, Customer.class);
		System.out.println(customer);
	}
}
