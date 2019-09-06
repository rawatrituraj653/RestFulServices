package com.info;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.info.serial.DateSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
 * this annotation is used to avoid null property
 */
@JsonSerialize(include = Inclusion.NON_NULL)

/*
 * @JsonPropertyOrder({ "customer-id", "customer_email", "account-balance",
 * "customer-name" }) 
 * TO set order in json format
 */
public class Customer {

	@JsonProperty("customer-id")
	private Integer id;
	@JsonProperty("customer-name")
	private String name;
	@JsonProperty("customer_email")
	/*@JsonIgnore 
	 * THIS IS USED TO IGNORE THE PROPERTY */
	private String email;
	@JsonProperty("account-balance")
	private Double balance;
	
	@JsonProperty("customer_dob")
	@JsonSerialize(using =DateSerialize.class)
	private Date dob;
}
