package com.app.book;

import javax.ws.rs.QueryParam;

public class BusTicket {

	private @QueryParam("from") String from ;
	private @QueryParam("to")String  to ;
	private @QueryParam ("fare") double  basefare ;
	private @QueryParam("coupon") String coupon;
	private double  discount;
	private double finalprice;
	
	public BusTicket() {
		
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getBasefare() {
		return basefare;
	}
	public void setBasefare(double basefare) {
		this.basefare = basefare;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getFinalprice() {
		return finalprice;
	}
	public void setFinalprice(double finalprice) {
		this.finalprice = finalprice;
	}	
	
}
