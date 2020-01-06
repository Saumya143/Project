package com.nt.test;





import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.weather.beans.WeatherForeCaster;
import com.weather.beans.WeatherForeCasterService;
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.weather.*")
public class TestWeatherForeCasterService {
  
	private static WeatherForeCaster weatherFOreCaster;
	private static WeatherForeCasterService service;
	
	//create logger object 
	private static Logger logger=Logger.getLogger(WeatherForeCaster.class);
	
	@BeforeClass
	public static void beforeClass() {
     service=new WeatherForeCasterService();
		
		
		//create a mock object for weatherForcaster
        weatherFOreCaster=PowerMockito.mock(WeatherForeCaster.class);
		//setting dummy behavior for weatherForcaster
		PowerMockito.when(weatherFOreCaster.getTempreture(700051)).thenReturn(37.5);
		PowerMockito.when(weatherFOreCaster.getTempreture(700052)).thenReturn(40.5);
		PowerMockito.when(weatherFOreCaster.getTempreture(700053)).thenReturn(38.5);

		service.setWeatherFOreCaster(weatherFOreCaster);

		
	}
	
	@Test
	public void testGetTemp() {
		
		//initialize log4j
		PropertyConfigurator.configure("src/main/java/com/nt/commons/Junit.properties");
		
			//BasicConfigurator.configure();
			logger.trace("this is the first test case");
			logger.error("temprature missmatch");
			logger.debug("this is the debug messages");
			logger.info("this is the info messages");
		double actual=service.getTempreture(700051);
		assertNotNull(service);
	}
	 
	@Test
	public void testGetTemp1() {
		
		double actual=service.getTempreture(700052);
		assertEquals(40.0, actual, 0.5);
	}
	@AfterClass
	public static void afterClass() {
		service=null;
	}
}
