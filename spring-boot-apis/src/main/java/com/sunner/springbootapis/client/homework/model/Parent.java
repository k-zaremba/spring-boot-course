package com.sunner.springbootapis.client.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parent{

	@JsonProperty("latt_long")
	private String lattLong;

	@JsonProperty("woeid")
	private int woeid;

	@JsonProperty("title")
	private String title;

	@JsonProperty("location_type")
	private String locationType;

	public void setLattLong(String lattLong){
		this.lattLong = lattLong;
	}

	public String getLattLong(){
		return lattLong;
	}

	public void setWoeid(int woeid){
		this.woeid = woeid;
	}

	public int getWoeid(){
		return woeid;
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
			"Parent{" + 
			"latt_long = '" + lattLong + '\'' + 
			",woeid = '" + woeid + '\'' + 
			",title = '" + title + '\'' + 
			",location_type = '" + locationType + '\'' + 
			"}";
		}
}