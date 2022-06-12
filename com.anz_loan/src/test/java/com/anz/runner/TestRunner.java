package com.anz.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.anz_loan.step_definitions",
		dryRun = false, 
		monochrome = true,
		plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
				"rerun:target/failed_scenarios.txt ",
				"html:target/cucumber-reports/repot.html",
				"pretty"
				
				}
		
		
		)
public class TestRunner {
	
	

}
 