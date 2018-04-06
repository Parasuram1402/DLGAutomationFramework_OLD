package com.dlg.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(features="features/BillingSummaryAPI.feature",glue={"com.dlg.stepdefinitions.acceptancetests"}, plugin={"pretty","json:report.json"}) 
public class RunnerClass {

}