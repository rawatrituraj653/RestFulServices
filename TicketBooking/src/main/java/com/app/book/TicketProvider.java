package com.app.book;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ticket")
public class TicketProvider {

	@GET
	@Path("/book")
	@Produces("application/json")
	public BusTicket bookTicket(@BeanParam BusTicket ticket) {
		
		double fare =ticket.getBasefare();
		String offer=ticket.getCoupon();
		System.out.println(offer);
		if("FIRST50".equalsIgnoreCase(offer)) {
			ticket.setDiscount(fare*50/100);
		}
		else if("HOLI22".equalsIgnoreCase(offer)) {
			ticket.setDiscount(fare*22/100);	
		}
		else {
			ticket.setDiscount(fare*1/100);
		}
		ticket.setFinalprice(fare-ticket.getDiscount());
		return ticket;
	}
}
