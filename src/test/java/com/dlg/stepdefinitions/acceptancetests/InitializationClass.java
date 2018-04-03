package com.dlg.stepdefinitions.acceptancetests;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dlg.common.libraries.EnvironmentVariablesHandler;
import com.dlg.common.libraries.ReportingUtilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.model.*;

public class InitializationClass {
    private static boolean executionFlag = false;
    private WebDriver driver;
    public EnvironmentVariablesHandler env;
    public ReportingUtilities Rep;
    public RuntimeOptions rto;
   

    public InitializationClass() throws Exception {
    	if (!executionFlag) {
    		
        	Rep=new ReportingUtilities(); 
        	env=new EnvironmentVariablesHandler();
        	executionFlag = true;
        }
    	String browserType=env.getEnvironmentVariables().get("BROWSER");
    	if(browserType.equalsIgnoreCase("chrome")){
    		System.setProperty("webdriver.chrome.driver", "./Resources/BrowserDrivers/chromedriver.exe");
    		driver = new ChromeDriver();
    	} else if(browserType.equalsIgnoreCase("firefox")){
    		System.setProperty("webdriver.firefox.marionette",  "./Resources/BrowserDrivers/geckodriver.exe");
    		driver = new FirefoxDriver();   		
    	}
    }

    public WebDriver getDriver() {
        return driver;
    }
    
    public Map<String,String> getEnvironmentVariables(){
    	return env.getEnvironmentVariables();
    }
    
    public File getReportFolder(){
    	return Rep.getReportFolder(); 
    }

    @After
    public void cleanUp() {
        driver.quit();

    }
    


}
