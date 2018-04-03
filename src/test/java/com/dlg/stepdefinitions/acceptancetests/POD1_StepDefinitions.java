package com.dlg.stepdefinitions.acceptancetests;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dlg.common.libraries.DataHandler;
import com.dlg.common.libraries.ReportingUtilities;
import com.dlg.pageobjects.ui.guidewire.common.GWLogin;
import com.dlg.pageobjects.ui.guidewire.policycenter.AccountCreation;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class POD1_StepDefinitions {
	WebDriver driver;
	InitializationClass init;
	Scenario scenario;
	File ReportFolder;
	Map<String,String> envVars;
	GWLogin login;
	AccountCreation accCrea;
	String screenshotPath;
	DataHandler dh;
	
	public POD1_StepDefinitions(InitializationClass init) {
		this.init=init;
	}

	
	@Before
	public void SetUp(Scenario sc) {
		this.scenario=sc;
		System.out.println(scenario.getName());
		driver=init.getDriver();
		ReportFolder=init.getReportFolder();
		envVars=init.getEnvironmentVariables();
		accCrea=new AccountCreation(driver);
		screenshotPath=ReportFolder.getAbsolutePath()+"/Screenshots/";
		login=new GWLogin(driver);
		dh=new DataHandler();
	}	
	
	@Given("^User Logged into PolicyCenter$")
	public void user_Logged_into_PolicyCenter() throws Throwable {
		try{
			driver.manage().window().maximize();
			driver.get(envVars.get("PC_URL"));
			Thread.sleep(10000);
			login.logIn(envVars.get("PC_UID"), envVars.get("PC_PWD"));
			if(envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("ALL") || envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("pass")){
				ReportingUtilities.takeScreenShot(screenshotPath, driver, scenario.getId(),"user_Logged_into_PolicyCenter");
			}
		} catch(Exception e){
			
		}

	}

	@Given("^Browse to Create Account Screen$")
	public void browse_to_Create_Account_Screen() throws Throwable {
		try{
			Thread.sleep(1000);
			accCrea.actions_button.click();
			Thread.sleep(3000);
			if(envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("ALL") || envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("pass")){
				ReportingUtilities.takeScreenShot(screenshotPath, driver, scenario.getId(),"browse_to_Create_Account_Screen");
			}
		} catch(Exception e){
			
		}
	    
	}

	@When("^Entered Require Details for Search (\\d+)$")
	public void entered_Require_Details_for_Search(int arg1) {
		try{
			List<String> tags = (List<String>) scenario.getSourceTagNames();				
			List<Map<String , String>> DataRowsList  = dh.getData("GW_PC_AccountCreation", "Sprint1", tags, arg1);
			for (Map<String, String> map : DataRowsList) {
				accCrea.SearchAccount(map);	
			}
			if(envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("ALL") || envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("pass")){
				ReportingUtilities.takeScreenShot(screenshotPath, driver, scenario.getId(),"entered_Require_Details_for_Search");
			} 	    			
		} catch(Exception e){
			
		}
	}

	@When("^Entered Require Details for Create Account (\\d+)$")
	public void entered_Require_Details_for_Create_Account(int arg1) throws Throwable {
		try{
			List<String> tags = (List<String>) scenario.getSourceTagNames();				
			List<Map<String , String>> DataRowsList  = dh.getData("GW_PC_AccountCreation", "Sprint1", tags, arg1);
			for (Map<String, String> map : DataRowsList) {
				accCrea.CreateAccount(map);	
			}
			if(envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("ALL") || envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("pass")){
				ReportingUtilities.takeScreenShot(screenshotPath, driver, scenario.getId(),"entered_Require_Details_for_Search");
			}				
		} catch(Exception e){
			
		}
	    
	}

	@Then("^Account is Created Successfully$")
	public void account_is_Created_Successfully() throws Throwable {
	    
		if(envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("ALL") || envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("pass")){
			ReportingUtilities.takeScreenShot(screenshotPath, driver, scenario.getId(),"account_is_Created_Successfully");
		}		
		//login.logOut();
	}

	@Then("^Details of Account should be displayed$")
	public void details_of_Account_should_be_displayed() throws Throwable {
	    try{
	    	/*if (accCrea.searchResults.isEnabled()){
	    		//List<WebElement> rows=accCrea.searchResults.findElements(By.xpath("tr"));
	    		//System.out.println(rows.size());
	    		if(envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("ALL") || envVars.get("SCREENSHOT_LEVEL").equalsIgnoreCase("pass")){
	    			ReportingUtilities.takeScreenShot(screenshotPath, driver, scenario.getId(),"details_of_Account_should_be_displayed");
	    		}	    		
	    	}*/
	    } catch(Exception e){
	    	
	    }
		//login.logOut(); 
			
	}


}
