package com.sunner.springbootapis.client.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SourcesItem{

	@JsonProperty("crawl_rate")
	private int crawlRate;

	@JsonProperty("title")
	private String title;

	@JsonProperty("slug")
	private String slug;

	@JsonProperty("url")
	private String url;

	public void setCrawlRate(int crawlRate){
		this.crawlRate = crawlRate;
	}

	public int getCrawlRate(){
		return crawlRate;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"SourcesItem{" + 
			"crawl_rate = '" + crawlRate + '\'' + 
			",title = '" + title + '\'' + 
			",slug = '" + slug + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}