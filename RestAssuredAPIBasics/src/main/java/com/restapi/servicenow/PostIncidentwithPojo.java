package com.restapi.servicenow;

public class PostIncidentwithPojo {
	
	
	private String short_description;
	private String description;
	private String category;
	
	
	
	
	public PostIncidentwithPojo(String shortdescription, String description, String category) {
		super();
		this.short_description = shortdescription;
		this.description = description;
		this.category = category;
	}
	
	
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "PostIncidentwithPojo [short_description=" + short_description + ", description=" + description
				+ ", category=" + category + "]";
	}
	

}
