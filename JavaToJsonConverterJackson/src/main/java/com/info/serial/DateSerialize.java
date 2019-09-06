package com.info.serial;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class DateSerialize  extends JsonSerializer<Date>{

		@Override
		public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
				throws IOException, JsonProcessingException {
		
			System.out.println("Date Comes from serializer class===>"+value);
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String date =dateFormat.format(value);
			jgen.writeString(date);			
		}
	
}
