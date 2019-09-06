package com.app.convert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.app.model.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonGsonConvert {

	public static void main(String[] args) throws IOException {

	empTojson();
	//empsToJson();	
	}

	public static void empsToJson() {
		Employee emp=new Employee();
		emp.setEmpid(10001);
		emp.setEmpName("Rituraj");
		emp.setEmpDept(20);
		emp.setLoc("New York");
		emp.setDate(new Date());
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		List<Employee> employees=Arrays.asList(emp,
				new Employee(10002, "James", 30, "Chilli", new Date()),
				new Employee(10003, "Clark", 30, "Jermany", new Date()),
				new Employee(10004, "Miller", 30, "London", new Date())
				);
		String emps=gson.toJson(employees);
		try(FileWriter fw=new FileWriter( new File("emps.json"))){
			fw.write(emps);		
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(emps);
	}

	public  static void empTojson() {
		Employee emp=new Employee();
		emp.setEmpid(10001);
		emp.setEmpName("Rituraj");
		emp.setEmpDept(20);
		emp.setLoc("New York");
		emp.setDate(new Date());
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String json=gson.toJson(emp);
		File file=new File("emp.json");
		try (FileWriter fileWriter=new FileWriter(file);){
			fileWriter.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(json);
	}
}
