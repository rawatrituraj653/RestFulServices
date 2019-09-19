package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Entity
@Table(name="USER_TAB")
@Data
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	@Id
	@GeneratedValue
	@Column(name="User_id")
	private Integer userId;
	@Column(name="User_Name",length = 20)
	private String userName;
	@Column(name="User_Email",length = 30)
	private String userEmail;
	@Column(name="User_Addr",length = 30)
	private String userAddr;
}
