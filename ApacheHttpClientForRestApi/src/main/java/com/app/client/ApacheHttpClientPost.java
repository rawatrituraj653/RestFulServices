package com.app.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.app.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApacheHttpClientPost {

	@SuppressWarnings("deprecation")
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
		
		DefaultHttpClient  client=new DefaultHttpClient();
		HttpPost post=new HttpPost(reqUrl);
		StringEntity entity=new StringEntity(jsonData);
		entity.setContentType("application/json");
		post.setEntity(entity);
		HttpResponse httpResponse=client.execute(post);
		if(httpResponse.getStatusLine().getStatusCode()==200) {
			BufferedReader  reader=new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			String str=reader.readLine();
			System.out.println(str);
		}
		else {
			System.out.println("There is Server Side Error....!!");
		}
	}
}
