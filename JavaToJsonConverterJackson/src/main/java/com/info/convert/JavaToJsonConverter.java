package com.info.convert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.info.Customer;

public class JavaToJsonConverter {

	 
	
	public static void main(String[] args) throws Exception{
		
		
		customerObjToJson();
		
		customerObjsToJson();
	
	}

	@SuppressWarnings("deprecation")
	private static void customerObjsToJson()
			throws ParseException, IOException, JsonGenerationException, JsonMappingException {
		String dob="1992-12-20";
		SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
		Date date=dateFormat.parse(dob);
		List<Customer> customers=Arrays.asList(
				new Customer(110002, "Amit", "Amit12@gmail.com", 5000.00, date),
				new Customer(110003, "Sumit", "Sumit22@gmail.com",4230.00,new Date(2016-1900,11-1,23)),
				new Customer(110004, "Kumar", "Kumar12@gmail.com", 6000.00, new Date(1998-1900,6,18)),
				new Customer(110005, "Ashok", "Ashokit12@gmail.com", 7450.00, new Date(1993-1900,5,16))
				);
		
		ObjectMapper mapper=new ObjectMapper();
		String customersJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customers);
		File file=new File("customers.json");
		FileWriter fileWriter=new FileWriter(file);
		fileWriter.write(customersJson);
		System.out.println(customersJson);
		fileWriter.close();
	}

	private static void customerObjToJson() throws IOException, JsonGenerationException, JsonMappingException, ParseException {
		
		String dob="1992-12-20";
		SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
		Date date=dateFormat.parse(dob);
		System.out.println("date===>>>>>>>>>>>"+date);	
		Customer customer=new  Customer();
		customer.setId(1001);
		customer.setName("Rituraj");
		customer.setEmail("Rrituraj047@gmail.com");
		customer.setBalance(20020.00);
		customer.setDob(date);
		ObjectMapper mapper=new ObjectMapper();
		String customerJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
		File src=new File("customer.json");
		try(FileWriter writer=new FileWriter(src)){
		writer.write(customerJson);
		System.out.println(customerJson);
		}
	}
}
