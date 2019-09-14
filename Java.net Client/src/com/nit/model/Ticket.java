package com.nit.model;


import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {
	@XmlElement(name="pnr-status")
	@JsonProperty("pnr-status")
	private String pnrStatus;
	@XmlElement(name="train-number")
	@JsonProperty("train-number")
	private Integer trainNumber;
	@JsonProperty("train-name")
	@XmlElement(name="train-name")
	private String trainName;
	@XmlElement(name="passenger-name")
	@JsonProperty("passenger-name")
	private String passengerName;
	@XmlElement(name="passenger-age")
	@JsonProperty("passenger-age")
	private Integer passengerAge;
	private String from;
	private String to;
	@XmlElement(name="journey-date")
	@JsonProperty("journey-date")
	private Date journeyDate;
	
	
}
