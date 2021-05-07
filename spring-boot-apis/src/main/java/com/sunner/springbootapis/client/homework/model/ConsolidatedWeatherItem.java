package com.sunner.springbootapis.client.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsolidatedWeatherItem{

	@JsonProperty("visibility")
	private double visibility;

	@JsonProperty("created")
	private String created;

	@JsonProperty("applicable_date")
	private String applicableDate;

	@JsonProperty("wind_direction")
	private double windDirection;

	@JsonProperty("predictability")
	private int predictability;

	@JsonProperty("wind_direction_compass")
	private String windDirectionCompass;

	@JsonProperty("weather_state_name")
	private String weatherStateName;

	@JsonProperty("min_temp")
	private double minTemp;

	@JsonProperty("weather_state_abbr")
	private String weatherStateAbbr;

	@JsonProperty("the_temp")
	private double theTemp;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("wind_speed")
	private double windSpeed;

	@JsonProperty("id")
	private long id;

	@JsonProperty("max_temp")
	private double maxTemp;

	@JsonProperty("air_pressure")
	private int airPressure;

	public void setVisibility(double visibility){
		this.visibility = visibility;
	}

	public double getVisibility(){
		return visibility;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setApplicableDate(String applicableDate){
		this.applicableDate = applicableDate;
	}

	public String getApplicableDate(){
		return applicableDate;
	}

	public void setWindDirection(double windDirection){
		this.windDirection = windDirection;
	}

	public double getWindDirection(){
		return windDirection;
	}

	public void setPredictability(int predictability){
		this.predictability = predictability;
	}

	public int getPredictability(){
		return predictability;
	}

	public void setWindDirectionCompass(String windDirectionCompass){
		this.windDirectionCompass = windDirectionCompass;
	}

	public String getWindDirectionCompass(){
		return windDirectionCompass;
	}

	public void setWeatherStateName(String weatherStateName){
		this.weatherStateName = weatherStateName;
	}

	public String getWeatherStateName(){
		return weatherStateName;
	}

	public void setMinTemp(double minTemp){
		this.minTemp = minTemp;
	}

	public double getMinTemp(){
		return minTemp;
	}

	public void setWeatherStateAbbr(String weatherStateAbbr){
		this.weatherStateAbbr = weatherStateAbbr;
	}

	public String getWeatherStateAbbr(){
		return weatherStateAbbr;
	}

	public void setTheTemp(double theTemp){
		this.theTemp = theTemp;
	}

	public double getTheTemp(){
		return theTemp;
	}

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	public int getHumidity(){
		return humidity;
	}

	public void setWindSpeed(double windSpeed){
		this.windSpeed = windSpeed;
	}

	public double getWindSpeed(){
		return windSpeed;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setMaxTemp(double maxTemp){
		this.maxTemp = maxTemp;
	}

	public double getMaxTemp(){
		return maxTemp;
	}

	public void setAirPressure(int airPressure){
		this.airPressure = airPressure;
	}

	public int getAirPressure(){
		return airPressure;
	}

	@Override
 	public String toString(){
		return 
			"ConsolidatedWeatherItem{" + 
			"visibility = '" + visibility + '\'' + 
			",created = '" + created + '\'' + 
			",applicable_date = '" + applicableDate + '\'' + 
			",wind_direction = '" + windDirection + '\'' + 
			",predictability = '" + predictability + '\'' + 
			",wind_direction_compass = '" + windDirectionCompass + '\'' + 
			",weather_state_name = '" + weatherStateName + '\'' + 
			",min_temp = '" + minTemp + '\'' + 
			",weather_state_abbr = '" + weatherStateAbbr + '\'' + 
			",the_temp = '" + theTemp + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",wind_speed = '" + windSpeed + '\'' + 
			",id = '" + id + '\'' + 
			",max_temp = '" + maxTemp + '\'' + 
			",air_pressure = '" + airPressure + '\'' + 
			"}";
		}
}