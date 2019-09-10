package com.nit.resources.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

	/* these method creation is optional in application class any one can override if we
	 * are using jersey 2.x and Resteasy because in jersey 1.x auto scanning is avilable 
	 *  but in others these factures are not avilable....
	 *  and if i want to make my  resource class as singleton then we have to option either we right 
	 *  annotation on top of resource class  that is @singleton or we can register our object by 
	 *  overriding getsingleton mehtod create set object and add our class object and then we get singleton
	 *    
	 */
	
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return super.getClasses();
	}
	@Override
	public Set<Object> getSingletons() {
		// TODO Auto-generated method stub
		return super.getSingletons();
	}
}
