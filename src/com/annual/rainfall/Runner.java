package com.annual.rainfall;

import java.io.*;
import java.util.*;



public class Runner {

	public static void main(String[] args) throws IOException {
		File f = new File("AllCityMonthlyRainfall.txt");
		List<AnnualRainfall> listOfRainfall = new ArrayList<>();
		RainfallReport rr = new RainfallReport();
		
		listOfRainfall = rr.generateRainfallReport(f);
		
		System.out.println("Records Processed by file : \n");
		for(AnnualRainfall ar : listOfRainfall) {
			System.out.println(ar.getCity_pincode()+","+ar.getCity_name()+","+ar.getAverage_annual_rainfall());
		}
		//add the processed record into database
		System.out.println("\nCity with maximum rainfall : "+rr.findMaximumRainfallCities());
	}

}
