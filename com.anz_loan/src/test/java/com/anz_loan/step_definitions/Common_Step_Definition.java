package com.anz_loan.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.anz.utilities.CommonUtils;
import com.anzloan.webdriver.manager.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Common_Step_Definition {
	
	
	
	//launch Browser
	
	
	
	private static final Logger LOGGER = LogManager.getLogger(Common_Step_Definition.class);

	
	@Before
	public void beforeScenario() {
		
		LOGGER.info("Execution started");
		
		try {
			LOGGER.info("Common Utils Instantiated");
			
			LOGGER.info("Loading property files");
			CommonUtils.getInstance().loadProperties();
			
			
		//	if (DriverManager.getDriver()==null) {
				LOGGER.info("Launching Browser");
			DriverManager.launchBrowser();
			DriverManager.getDriver().manage().window().maximize();
			
			CommonUtils.getInstance().initWebElements();
			
			
			//}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void afterScenario() {
		
		DriverManager.getDriver().quit();
		
	}
	
		
	
	
}
