package com.nit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Student {
	@XmlElement(name="student-id")
	private Integer studentId;
	@XmlElement(name="student-name")
	private String studentName;
	@XmlElement(name="student-age")
	private Integer studentAge;
	@XmlElement(name="student-gender")
	private String studentGender;
	@XmlElement(name="student-fee")
	private Double studentFee;
	 
}
