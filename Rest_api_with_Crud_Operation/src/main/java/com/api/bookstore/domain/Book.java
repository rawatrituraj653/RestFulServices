package com.api.bookstore.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	@JsonProperty("book-isbn")
	private String bookIsbn;
	private String bookName;
	@JsonProperty("book-author")
	private String bookAuthor;
	@JsonProperty("book-price")
	private Double bookPrice;
	@JsonProperty("release-date")
	private Date relDate; 
}
