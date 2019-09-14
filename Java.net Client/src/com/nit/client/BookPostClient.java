package com.nit.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nit.model.Book;

public class BookPostClient {
	public static void main(String[] args) throws Exception {
		Book book=new  Book();
		book.setBookIsbn("SPR123");
		book.setBookName("Spring");
		book.setBookAuthor("Rod Johnson");
		book.setBookPrice(400.00);
		book.setRelDate(new Date());
		ObjectMapper mapper=new ObjectMapper();
		String jsonData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
		System.out.println(jsonData);
		
		String reqUrl="http://localhost:8085/Rest_api_with_Crud_Operation/rest/book/save";
		URL url=new URL(reqUrl);
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		OutputStream stream=connection.getOutputStream();
		stream.write(jsonData.getBytes());
		stream.flush();
		
		int statusCode=connection.getResponseCode();
		if(statusCode==200) {
			InputStream stream2 = connection.getInputStream();
			BufferedReader bufferedReader=new  BufferedReader(new InputStreamReader(stream2));
			System.out.println(bufferedReader.readLine());
			connection.disconnect();
		}
		else {
			System.out.println("There is a Server side Error.....!!");
		}
	}
}
