package com.nit.resource.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Employee {

	private Integer eid;
	private  String ename;
	private  Double sal;
}
