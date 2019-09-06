package com.uidai.data;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	
	 private Integer  custId;
	 private  String custName;
	 private String custEmail;
	 private Double custAmt;
	private List<String>items;
	
}
