package com.dlg.stepdefinitions.acceptancetests;

import java.util.List;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SampleStefDef {
	public Scenario scenario; 
	
	@Before
	public void SetUp(Scenario sc){
		System.out.println("Start of Scenario "+sc.getName());
		this.scenario=sc;
	}
	
	@After 
	public void TearDown(Scenario sc){
		System.out.println("Scenario "+sc.getName()+" end with "+sc.getStatus()+" status");	
	}
	
	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
	   List<String> tags = (List<String>) scenario.getSourceTagNames();
	   for(String tag : tags){
		   System.out.println(tag);
	   }
	}

	@Given("^some other precondition$")
	public void some_other_precondition() throws Throwable {
		List<String> tags = (List<String>) scenario.getSourceTagNames();
		   for(String tag : tags){
			   System.out.println(tag);
		   }
	}

	@When("^I complete action$")
	public void i_complete_action() throws Throwable {
		List<String> tags = (List<String>) scenario.getSourceTagNames();
		   for(String tag : tags){
			   System.out.println(tag);
		   }
	}

	@When("^some other action$")
	public void some_other_action() throws Throwable {
		List<String> tags = (List<String>) scenario.getSourceTagNames();
		   for(String tag : tags){
			   System.out.println(tag);
		   }
	}

	@When("^yet another action$")
	public void yet_another_action() throws Throwable {
		List<String> tags = (List<String>) scenario.getSourceTagNames();
		   for(String tag : tags){
			   System.out.println(tag);
		   }
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {
		List<String> tags = (List<String>) scenario.getSourceTagNames();
		   for(String tag : tags){
			   System.out.println(tag);
		   }
	}

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
		List<String> tags = (List<String>) scenario.getSourceTagNames();
		   for(String tag : tags){
			   System.out.println(tag);
		   }
	}

	@Given("^I want to write a step with name(\\d+)$")
	public void i_want_to_write_a_step_with_name(int arg1) throws Throwable {
		List<String> tags = (List<String>) scenario.getSourceTagNames();
		   for(String tag : tags){
			   System.out.println(tag);
		   }
	}

	@When("^I check for the (\\d+) in step$")
	public void i_check_for_the_in_step(int arg1) throws Throwable {
		List<String> tags = (List<String>) scenario.getSourceTagNames();
		   for(String tag : tags){
			   System.out.println(tag);
		   }
	}

	@Then("^I verify the success in step$")
	public void i_verify_the_success_in_step() throws Throwable {
		List<String> tags = (List<String>) scenario.getSourceTagNames();
		   for(String tag : tags){
			   System.out.println(tag);
		   }
	}

	@Then("^I verify the Fail in step$")
	public void i_verify_the_Fail_in_step() throws Throwable {
		List<String> tags = (List<String>) scenario.getSourceTagNames();
		   for(String tag : tags){
			   System.out.println(tag);
		   }
	}


}
