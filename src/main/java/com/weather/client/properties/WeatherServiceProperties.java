package com.weather.client.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("weather.client")

public class WeatherServiceProperties {
	private int readTimeOut;
	private int connectTimeOut;
	private String apiUrl;
	private String apiKey;
	
	public int getReadTimeOut() {
		return readTimeOut;
	}
	public void setReadTimeOut(int readTimeOut) {
		this.readTimeOut = readTimeOut;
	}
	public int getConnectTimeOut() {
		return connectTimeOut;
	}
	public void setConnectTimeOut(int connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	

}
