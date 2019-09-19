package com.app.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class ApacheHttpClientGet {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String resUrl="http://localhost:8085/JaxRs_ExceptionMapper/api/info/msg";
		DefaultHttpClient client=new DefaultHttpClient();
		HttpGet get=new  HttpGet(resUrl);
		HttpResponse httpResponse=client.execute(get);
		
		if(httpResponse.getStatusLine().getStatusCode()==200) {
			BufferedReader reader=new BufferedReader(
					new InputStreamReader(httpResponse.getEntity().getContent()));
			while (reader.ready()) {
			String read=reader.readLine();
			System.out.println(read);
			}
		}else {
			System.out.println("There is error Server side ..........!!");
		}
		
	}
}
