
package com.uidai.mapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.uidai.data.Customer;

public class JavaToJsonMapper {

	
	public static void main(String[] args) throws Exception{
	
		jsonToJavaObj();
		javaObjsJson();
		Thread.sleep(50000);
		javaObjJson();
		
		
	}

	private static void jsonToJavaObj() throws IOException, JsonParseException, JsonMappingException {
		String json="\r\n" + 
				"{\r\n" + 
				"  \"custId\" : 101,\r\n" + 
				"  \"custName\" : \"Rituraj\",\r\n" + 
				"  \"custEmail\" : \"Rrtiuraj047@gmail.com\",\r\n" + 
				"  \"custAmt\" : 190000.0,\r\n" + 
				"  \"items\" : [ \"sugar\", \"oil\", \"rotimakers\", \"henkerchief\" ]\r\n" + 
				"}\r\n";
		ObjectMapper mapper=new ObjectMapper();
		Customer customer= mapper.readValue(json,Customer.class);
		System.out.println(customer);
	}

	private static void javaObjsJson() throws IOException, JsonGenerationException, JsonMappingException {
		List<String> items=Arrays.asList("sugar","oil","rotimakers","henkerchief");	
		
		List<Customer> customers=Arrays.asList(
					new Customer(101, "Amit", "amit12@gmail.com", 4753.00,items),
					new Customer(102, "Sumit", "sumit60@gmail.com", 7650.00,items),
					new Customer(103, "Abhi", "abhi22@gmail.com", 4654.00,items),
					new Customer(104, "Mahi", "mahi123@gmail.com", 4430.00,items),
					new Customer(105, "Nishi", "nishi132@gmail.com", 5430.00,items),
					new Customer(106, "Suraj", "suraj1255@gmail.com", 6250.00,items)
				); 
		
		ObjectMapper  mapper=new ObjectMapper();
		String customerjsons=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customers);
		System.out.println(customerjsons);
	}

	/*
	 * 
	 * defaultPrettyPrintingWriter() this is deprecated instead of that use   writerWithDefaultPrettyPrinter()
	 * 
	 */	
	private static void javaObjJson() throws IOException, JsonGenerationException, JsonMappingException {
		List<String> items=Arrays.asList("sugar","oil","rotimakers","henkerchief");	
			String itr=items.stream().collect(Collectors.joining(", "));
			System.out.println(itr);
		Customer customer=new Customer(101, "Rituraj", "Rrtiuraj047@gmail.com", 190000.00,items);
		ObjectMapper mapper=new ObjectMapper();
		//String customerJson=mapper.defaultPrettyPrintingWriter().writeValueAsString(customer);
		String customerJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
			System.out.println(customerJson);
	}
}
