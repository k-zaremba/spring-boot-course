package com.sunner.springbootapis.client.homework.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherInfo{

	@JsonProperty("sun_set")
	private String sunSet;

	@JsonProperty("parent")
	private Parent parent;

	@JsonProperty("sources")
	private List<SourcesItem> sources;

	@JsonProperty("latt_long")
	private String lattLong;

	@JsonProperty("timezone")
	private String timezone;

	@JsonProperty("timezone_name")
	private String timezoneName;

	@JsonProperty("woeid")
	private int woeid;

	@JsonProperty("sun_rise")
	private String sunRise;

	@JsonProperty("consolidated_weather")
	private List<ConsolidatedWeatherItem> consolidatedWeather;

	@JsonProperty("time")
	private String time;

	@JsonProperty("title")
	private String title;

	@JsonProperty("location_type")
	private String locationType;

	private String imageUrl;

	public ConsolidatedWeatherItem getTodayWeather(){
		return this.consolidatedWeather.get(0);
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setSunSet(String sunSet){
		this.sunSet = sunSet;
	}

	public String getSunSet(){
		return sunSet;
	}

	public void setParent(Parent parent){
		this.parent = parent;
	}

	public Parent getParent(){
		return parent;
	}

	public void setSources(List<SourcesItem> sources){
		this.sources = sources;
	}

	public List<SourcesItem> getSources(){
		return sources;
	}

	public void setLattLong(String lattLong){
		this.lattLong = lattLong;
	}

	public String getLattLong(){
		return lattLong;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setTimezoneName(String timezoneName){
		this.timezoneName = timezoneName;
	}

	public String getTimezoneName(){
		return timezoneName;
	}

	public void setWoeid(int woeid){
		this.woeid = woeid;
	}

	public int getWoeid(){
		return woeid;
	}

	public void setSunRise(String sunRise){
		this.sunRise = sunRise;
	}

	public String getSunRise(){
		return sunRise;
	}

	public void setConsolidatedWeather(List<ConsolidatedWeatherItem> consolidatedWeather){
		this.consolidatedWeather = consolidatedWeather;
	}

	public List<ConsolidatedWeatherItem> getConsolidatedWeather(){
		return consolidatedWeather;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setLocationType(String locationType){
		this.locationType = locationType;
	}

	public String getLocationType(){
		return locationType;
	}

	@Override
 	public String toString(){
		return 
			"WeatherInfo{" + 
			"sun_set = '" + sunSet + '\'' + 
			",parent = '" + parent + '\'' + 
			",sources = '" + sources + '\'' + 
			",latt_long = '" + lattLong + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",timezone_name = '" + timezoneName + '\'' + 
			",woeid = '" + woeid + '\'' + 
			",sun_rise = '" + sunRise + '\'' + 
			",consolidated_weather = '" + consolidatedWeather + '\'' + 
			",time = '" + time + '\'' + 
			",title = '" + title + '\'' + 
			",location_type = '" + locationType + '\'' + 
			"}";
		}
}