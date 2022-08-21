package com.annual.rainfall;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.exception.*;

public class RainfallReport {

	List<AnnualRainfall> listOfRainfall = new ArrayList<>();
	
	public List<AnnualRainfall> generateRainfallReport(File f) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(f));
		ArrayList<Double> monthlyRainfall = new ArrayList<Double>();   
		
		
		String line;
		while((line=br.readLine())!=null) {
			String[] record = line.split(",");
			//System.out.println(record.length);
			String pincode = record[0];
			try {
				if(!validate(pincode))
					continue;
			} catch (InvalidPinCodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String city = record[1];
			for(int i=2;i<record.length;i++) {
				monthlyRainfall.add(Double.valueOf(record[i]));
			}
			
			double annualRain = calculateAverageAnnualRainfall(monthlyRainfall);
			
			AnnualRainfall a = new AnnualRainfall();
			a.setCity_pincode(pincode);
			a.setCity_name(city);
			a.setAverage_annual_rainfall(annualRain);
			
			listOfRainfall.add(a);
		}
		br.close();
		return listOfRainfall;
		
	}
	
	public String findMaximumRainfallCities() {
		double max=Integer.MIN_VALUE;
		String city ="";
		for(AnnualRainfall a : listOfRainfall) {
			if(a.getAverage_annual_rainfall() > max) {
				max=a.getAverage_annual_rainfall();
				city=a.getCity_name();
			}
		}
		return city;
		
	}
	
	
	private boolean validate(String cityPincode) throws InvalidPinCodeException {
		if(!(cityPincode.length()==5))
			throw new InvalidPinCodeException("Invalid Code");
		return true;
	}
	
	private double calculateAverageAnnualRainfall (ArrayList<Double> monthlyRainfall){
	    double total=0,average=0.0;
	    for(double i : monthlyRainfall) {
	    	total+=i;
	    }
	    average =  total/12;
	    return Math.round(average);
	}

}
