package com.weather.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.client.model.WeatherReport;
import com.weather.client.service.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired
	WeatherService service;
	
	@RequestMapping(value = "/defaultWeatherTest", method = RequestMethod.GET,
			produces = { "application/json", "application/xml" })
	public WeatherReport defaultWeahter() {
		WeatherReport report = new WeatherReport();
		report.setDescription("God it is Cold");
		return report;

		
	}
	
	@RequestMapping(value = "/getWeather", method = RequestMethod.GET,
			produces = { "application/json", "application/xml" })
	public WeatherReport getWeather(@RequestParam("city") String city) {
		WeatherReport report = new WeatherReport();
		report.setDescription("God it is Cold in "+city);
		report = service.getWeatherByCity(city);
		return report;

		
	}
}
