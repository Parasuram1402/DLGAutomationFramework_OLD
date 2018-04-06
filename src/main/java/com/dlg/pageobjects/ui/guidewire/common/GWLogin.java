package com.dlg.pageobjects.ui.guidewire.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.dlg.pageobjects.ui.BasePageClass;

public class GWLogin extends BasePageClass {
WebDriver driver;

@FindBy(xpath="//input[@id='Login:LoginScreen:LoginDV:username-inputEl']")
WebElement userName;

@FindBy(xpath="//input[@id='Login:LoginScreen:LoginDV:password-inputEl']")
WebElement password;

@FindBy(linkText ="Log In")
WebElement logIn;

@FindBy(id="TabLinkMenuButton-btnIconEl")
WebElement menuButton;

@FindBy(xpath="//a[@id='TabBar:LogoutTabBarLink-itemEl']/span")
WebElement logOut;

@FindBy(xpath="//span[@id='button-1005-btnInnerEl']")
WebElement logOutOk;

	public GWLogin(WebDriver driver){
	    //this.driver = driver;
	    super(driver);
	    this.driver=super.driver;
	}

	public void logIn(String uid, String pwd){
		userName.sendKeys(uid);
		password.sendKeys(pwd);
		logIn.click();
	}
	
	public void logOut(){
		menuButton.click();
		logOut.click();
		logOutOk.click();
	}

}