package com.weather.client.service;

import java.text.DecimalFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.weather.client.model.WeatherReport;
import com.weather.client.properties.WeatherServiceProperties;



@Component
public class WeatherService {

	private final RestOperations rest;
	private final String serviceUrl;
	private final String serviceUrlKey;
	public WeatherService(final RestTemplateBuilder builder, final WeatherServiceProperties props) {
		this.rest = builder.setReadTimeout(props.getReadTimeOut())
		.setConnectTimeout(props.getConnectTimeOut())
		.build();
		this.serviceUrl = props.getApiUrl();
		this.serviceUrlKey = props.getApiKey();
	}
	
	public WeatherReport getWeatherByCity(String city) {
		WeatherReport report  = new WeatherReport();
		String reportResult = rest.getForObject(serviceUrl,String.class,city,serviceUrlKey);
		try {
			JSONObject  reportObject = new JSONObject(reportResult);
			report = getReport(report,reportObject);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return report;
	}

	private WeatherReport getReport(WeatherReport report, JSONObject reportObject) {
		// TODO Auto-generated method stub
		JSONObject mainObject;
		JSONObject sysObject;
		JSONArray weatherArray;
		try {
			mainObject = reportObject.getJSONObject("main");
			
			report.setCurrentTemperature(convertToCelsius(mainObject.getString("temp")));
			report.setHumidity(mainObject.getString("humidity"));
			report.setMinTemperature(convertToCelsius(mainObject.getString("temp_min")));
			report.setMaxTemperature(convertToCelsius(mainObject.getString("temp_max")));
			
			sysObject = reportObject.getJSONObject("sys");
			report.setCountry(sysObject.getString("country"));
			
			weatherArray = reportObject.getJSONArray("weather");
			report.setDescription(weatherArray.getJSONObject(0).getString("description"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return report;
	}

	private String convertToCelsius(String string) {
		// TODO Auto-generated method stub
		DecimalFormat df2 = new DecimalFormat(".##");
		return df2.format((Double.parseDouble(string)-273.15));
	}
}
