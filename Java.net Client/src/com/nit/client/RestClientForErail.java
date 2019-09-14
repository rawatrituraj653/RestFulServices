package com.nit.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nit.model.Ticket;

public class RestClientForErail {

	public static void main(String[] args) throws Exception{
		String str="http://localhost:8085/JaxRs_ExceptionMapper/api/erail/ticket/ABC123";
		URL url=new URL(str);
		HttpURLConnection con= (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept","application/json");
		int code=con.getResponseCode();
		if(code==200) {
			InputStream stream=con.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
			
			String line =reader.readLine();
			System.out.println(line);
			ObjectMapper mapper=new ObjectMapper();
			Ticket ticket=mapper.readValue(line, Ticket.class);
			System.out.println(ticket);
		
			con.disconnect();
		}
		
		else {
			System.out.println("Some Error Ocurred in Server Side......!!");
		}
	}	
}
