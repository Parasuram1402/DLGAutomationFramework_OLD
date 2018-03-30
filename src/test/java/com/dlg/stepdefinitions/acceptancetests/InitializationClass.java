package com.dlg.stepdefinitions.acceptancetests;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
   
    @Before
    public void initializeObjects() throws Exception {
    	System.setProperty("webdriver.chrome.driver", "./Resources/BrowserDrivers/chromedriver.exe");
    	driver = new ChromeDriver();
    	if (!executionFlag) {
        	Rep=new ReportingUtilities(); 
        	env=new EnvironmentVariablesHandler();
//        	features="features",glue={"com.dlg.stepdefinitions.acceptancetests"}, plugin={"pretty","json:report.json"}
 /*       	final 
        	RuntimeOptions runtimeOptions = new RuntimeOptions(Arrays.asList(
                    "--plugin", "pretty","json:D:\\report.json"
                    )) ;        */
        	
        	//System.out.println(rto.getGlue().toString());
        	executionFlag = true;
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
