package com.dlg.runner;
import java.io.File;
import java.io.FileInputStream;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue={"com.dlg.stepdefinitions.acceptancetests"}, plugin={"pretty","json:report.json"}) 
public class TestRunner {

	
	@AfterClass
	public static void postExecution() throws Exception{
		File envFile = new File("./Resources/Temp/tempdata.txt");
		FileInputStream envFileIS = new FileInputStream(envFile);
		byte[] data = new byte[(int) envFile.length()];
		envFileIS.read(data);
		envFileIS.close();
		String fileData = new String(data, "UTF-8");
		fileData=fileData.replace("\n", "");
		fileData=fileData.replace("\r", "");
		envFile=new File("report.json");
		envFile.renameTo(new File(fileData+"/JSON/" + envFile.getName()));
	}
}