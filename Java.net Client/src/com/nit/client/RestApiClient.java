package com.nit.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestApiClient {
	
	public static void main(String[] args) throws IOException {
		
		String resUrl="http://localhost:8085/JaxRs_ExceptionMapper/api/info/msg";
		URL  url=new URL(resUrl);
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		int statusCode =connection.getResponseCode();
		if(statusCode==200) {
			InputStream inputStream=connection.getInputStream();
			BufferedReader buf=new BufferedReader(new InputStreamReader(inputStream));
			while (buf.ready()) {
				System.out.println(buf.readLine());
			}
			connection.disconnect();
			
		}
		else {
			System.out.println("Some ErrorOccured Connection Not Established.......");
		}	
	}
	}


