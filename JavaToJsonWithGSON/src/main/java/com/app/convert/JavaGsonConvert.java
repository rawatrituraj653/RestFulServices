package com.app.convert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.app.model.Employee;
import com.google.gson.Gson;

public class JavaGsonConvert {

	public static void main(String[] args) {
		
		
		jsonToEmpObj();
		jsonToEmps();
	
		
	}

	public static void jsonToEmps() {
		Gson gson=new Gson();
			
		try {
			FileReader fr=new FileReader(new File("emps.json"));
			Employee [] emp=gson.fromJson(fr, Employee[].class);
			List<Employee> emps=Arrays.asList(emp);
			emps.forEach(System.out::println);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void jsonToEmpObj() {
		Gson gson=new Gson();
		File src=new File("emp.json");
		FileReader fileReader;
		try {
			fileReader = new FileReader(src);
			Employee emp=gson.fromJson(fileReader, Employee.class);
			System.out.println(emp);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
