package com.nt.test;





import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.weather.beans.WeatherForeCaster;
import com.weather.beans.WeatherForeCasterService;

public class TestWeatherForeCasterService {
  
	private static WeatherForeCaster weatherFOreCaster;
	private static WeatherForeCasterService service;
	
	
	@BeforeClass
	public static void beforeClass() {
     service=new WeatherForeCasterService();
		
		
		//create a mock object for weatherForcaster
		weatherFOreCaster=EasyMock.createMock(WeatherForeCaster.class);
		//setting dummy behavior for weatherForcaster
		EasyMock.expect(weatherFOreCaster.getTempreture(700051)).andReturn(42.5);
		EasyMock.expect(weatherFOreCaster.getTempreture(700052)).andReturn(-34.5);
		EasyMock.expect(weatherFOreCaster.getTempreture(700053)).andReturn(40.5);
		EasyMock.expect(weatherFOreCaster.getTempreture(700054)).andReturn(40.5);
		EasyMock.replay(weatherFOreCaster);
		
		service.setWeatherFOreCaster(weatherFOreCaster);

		
	}
	
	@Test
	public void testGetTemp() {
				
		double actual=service.getTempreture(700051);
		assertNotNull(service);
	}
	 
	@Test
	public void testGetTemp1() {
				
		double actual=service.getTempreture(700052);
		assertEquals(-34.0, actual, 0.5);
	}
	@AfterClass
	public static void afterClass() {
		service=null;
	}
}
