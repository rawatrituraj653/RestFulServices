package com.app.model;

import java.util.Date;

public class Employee {

	private Integer empid;
	private String empName;
	private Integer empDept;
	private String loc;
	private Date dob;
	
	
	public Employee() {

	}
	public Employee(Integer empid, String empName, Integer empDept, String loc, Date dob) {
		this.empid = empid;
		this.empName = empName;
		this.empDept = empDept;
		this.loc = loc;
		this.dob = dob;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpDept() {
		return empDept;
	}
	public void setEmpDept(Integer empDept) {
		this.empDept = empDept;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Date getDate() {
		return dob;
	}
	public void setDate(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", empDept=" + empDept + ", loc=" + loc + ", dob="
				+ dob + "]";
	}
	
}
