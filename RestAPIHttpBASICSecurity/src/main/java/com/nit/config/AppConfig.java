package com.nit.config;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest/*")
public class AppConfig extends  Application {
	
	public AppConfig() {
		System.out.println("AppConfig :: constructor");
	}

	@Override
	public Map<String, Object> getProperties() {
	
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("jersey.config.server.provider.packages", "com.nit.resources");
		return map;
	}
}
