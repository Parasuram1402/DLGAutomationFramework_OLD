package com.dlg.common.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySample {

	public static void main(String[] args) {
		File envFile = new File("./Resources/Temp/tempdata.txt");
		FileInputStream envFileIS;
		try {
    		System.setProperty("webdriver.firefox.marionette",  "./Resources/BrowserDrivers/geckodriver.exe");
    		WebDriver driver = new FirefoxDriver(); 
    		driver.get("http://www.googole.co.in");
    		
    		Thread.sleep(5000);
    		driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
