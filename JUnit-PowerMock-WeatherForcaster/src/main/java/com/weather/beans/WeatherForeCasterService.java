package com.weather.beans;

public class WeatherForeCasterService {

	private WeatherForeCaster weatherFOreCaster;

	public void setWeatherFOreCaster(WeatherForeCaster weatherFOreCaster) {
		this.weatherFOreCaster = weatherFOreCaster;
	}
	
	public double getTempreture(long zipCode) {
		double temprature=weatherFOreCaster.getTempreture(zipCode);
	    return temprature;
	}
}
