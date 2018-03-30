package com.dlg.utilities;
import com.dlg.pageobjects.api.guidewire.billingcenter.globalweather.GlobalWeatherStub;
import com.dlg.pageobjects.api.guidewire.billingcenter.globalweather.GlobalWeatherStub.GetCitiesByCountry;
import com.dlg.pageobjects.api.guidewire.billingcenter.globalweather.GlobalWeatherStub.GetCitiesByCountryResponse;

public class SoapCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

		       GlobalWeatherStub stub = new GlobalWeatherStub("http://www.webservicex.net/globalweather.asmx");
		       GetCitiesByCountry getCities=new GetCitiesByCountry();
		       getCities.setCountryName("India");

		       GetCitiesByCountryResponse getCitiesResp=stub.getCitiesByCountry(getCities);

		       System.out.println("Cities in India " + getCitiesResp.getGetCitiesByCountryResult());

		       } catch (Exception e) {
		       e.printStackTrace();
		      }
		    }
}


