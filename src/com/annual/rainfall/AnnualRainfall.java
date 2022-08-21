package com.annual.rainfall;

public class AnnualRainfall {
	
	private String city_pincode;
	private String city_name;
	private double average_annual_rainfall;
	
	public AnnualRainfall() {
		
	}
	
	public AnnualRainfall(String city_pincode, String city_name, double average_annual_rainfall) {
		this.city_pincode = city_pincode;
		this.city_name = city_name;
		this.average_annual_rainfall = average_annual_rainfall;
	}
	
	public String getCity_pincode() {
		return city_pincode;
	}
	public void setCity_pincode(String city_pincode) {
		this.city_pincode = city_pincode;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public double getAverage_annual_rainfall() {
		return average_annual_rainfall;
	}
	public void setAverage_annual_rainfall(double average_annual_rainfall) {
		this.average_annual_rainfall = average_annual_rainfall;
	}
	
	

}
