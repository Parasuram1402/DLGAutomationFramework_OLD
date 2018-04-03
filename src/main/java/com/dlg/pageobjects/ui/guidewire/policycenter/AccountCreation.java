package com.dlg.pageobjects.ui.guidewire.policycenter;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.dlg.pageobjects.ui.BasePageClass;

public class AccountCreation extends BasePageClass {
	//actions button
	@FindBy(xpath="//*[@id=\'Desktop:DesktopMenuActions-btnEl\']")
	public WebElement actions_button;
	
	//new account button
	@FindBy(xpath="//*[@id=\'Desktop:DesktopMenuActions:DesktopMenuActions_Create:DesktopMenuActions_NewAccount-textEl\']")
	public WebElement new_Account;
	
	//company_name - text box
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:GlobalContactNameInputSet:Name-inputEl\']")
	public WebElement company_name;
	
	//company_name - check box
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:CompanyNameExact-inputEl\']")
	public WebElement company_name_checkbox;
	
	//First_name
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:GlobalPersonNameInputSet:FirstName-inputEl\']")
	public WebElement first_name;
	
	//Last_name
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:GlobalPersonNameInputSet:LastName-inputEl\']")
	public WebElement last_name;
		
	//first_name - check box
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:FirstNameExact-inputEl\']")
	public WebElement first_name_checkbox;
		
	//last_name - check box
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:LastNameExact-inputEl\']")
	public WebElement last_name_checkbox;
	
	//country drop down
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:AddressOwnerAddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl\']")
	public WebElement country;
	
	//town/city text box
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:AddressOwnerAddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl\']")
	public WebElement city;
		
	//post code text box
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:AddressOwnerAddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl\']")
	public WebElement postcode;
	
	//search button
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search\']")
	public WebElement search;
	
	//reset button
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search\']")
	public WebElement reset;
	
	//Create new account
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountButton-btnInnerEl\']")
	public WebElement Create_new_account;
	
	//company
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountButton:NewAccount_Company-itemEl\']")
	public WebElement click_company;
	
	//person
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountButton:NewAccount_Person-itemEl\']")
	public WebElement click_person;
		
	//address book
	@FindBy(xpath="//*[@id=\'NewAccount:NewAccountScreen:NewAccountButton:NewAccount_FromAB-textEl\']")
	public WebElement click_address_book;
	
	//account search results
	@FindBy(xpath="//tbody[@id='NewAccount:NewAccountScreen:NewAccountSearchResultsLV_ref-tbody']/tr[3]/td")
	public WebElement searchResults;

	public AccountCreation(WebDriver driver){
	    //this.driver = driver;
	    super(driver);
	    this.driver=super.driver;
	}
	public void CreateAccount(Map<String, String> map) throws InterruptedException{
		try{
			SearchAccount(map);
			Create_new_account.click();	
			click_person.click();		
			
		} catch(Exception e){
			
		}
	}
	
	public void SearchAccount(Map<String, String> map) {
		 // actions_button.click();
		try{
			Thread.sleep(5000);
			  new_Account.click();

			  first_name.sendKeys(map.get("FirstName"));
			  last_name.sendKeys(map.get("LastName"));
			  if(map.get("Country")!=null){
				  country.click();
				  country.sendKeys(map.get("Country"));
				  country.sendKeys(Keys.ENTER);
			  }
			  Thread.sleep(2000);
			  if(map.get("City")!=null)	  city.sendKeys(map.get("City"));
			  if(map.get("Postcode")!=null) postcode.sendKeys(map.get("Postcode"));
			  search.click();
			
		} catch(Exception e) {
			
		}
	}

}
