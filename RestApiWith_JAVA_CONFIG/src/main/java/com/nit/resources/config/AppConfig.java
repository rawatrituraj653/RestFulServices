package com.nit.resources.config;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/*")
public class AppConfig extends Application{

	public AppConfig() {
		System.out.println("AppConfig:: Constructor");
	}
	
	@Override
	public Map<String, Object> getProperties() {
	Map<String,Object> map=new  HashMap<>();
	map.put("jersey.config.server.provider.packages", "com.nit.resources");
	return map;
	}
}
