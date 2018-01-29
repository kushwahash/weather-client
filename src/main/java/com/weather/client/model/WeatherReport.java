package com.weather.client.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WeatherReport {
	private String country;
	private String description;
	private String minTemperature;
	private String maxTemperature;
	private String currentTemperature;
	private String humidity;
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(String minTemperature) {
		this.minTemperature = minTemperature;
	}

	public String getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(String maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public String getCurrentTemperature() {
		return currentTemperature;
	}

	public void setCurrentTemperature(String currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

}
