 package com.anzloan.webdriver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.anz.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public static WebDriver getDriver() {
		return driver;
	}


	private static WebDriver driver = null;
	
//	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
	
	
public static void launchBrowser() {
		
		try {
			switch (Constants.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
				

			default:
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
 