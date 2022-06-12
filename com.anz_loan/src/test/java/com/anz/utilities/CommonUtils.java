package com.anz.utilities;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.anz.constants.Constants;
import com.anz.page.objects.LoanEstimatePage;
import com.anzloan.webdriver.manager.DriverManager;

public class CommonUtils {
	
	
	private static CommonUtils commonUtilsInstance = null;
	
	private CommonUtils () {
		
		
	}
	
	public static CommonUtils getInstance() {
		
		if(commonUtilsInstance==null) {
			commonUtilsInstance = new CommonUtils();
		}
		return commonUtilsInstance;
	}
	
	
	
	public  void loadProperties()  {
		
		
		
		Properties prop = new Properties();
		
		try {
			prop.load(getClass().getResourceAsStream("/config.properties"));	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	Constants.APP_URL =	prop.getProperty("URL");
	Constants.BROWSER =	prop.getProperty("BROWSER");
	Constants.ERROR_MESSAGE = prop.getProperty("ERROR_MESSAGE");
	Constants.LOAN_AMOUNT = prop.getProperty("LOAN_AMOUNT");
	
	
		
	}

	public void initWebElements() {
		
		PageFactory.initElements(DriverManager.getDriver(), LoanEstimatePage.getInstance());
	}
	
	public void selectFromDropDown (WebElement dropdown, String howTo, String Value) {
		
		Select select = new Select (dropdown);
		
		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(Value));
		break;
		
		case "value":
			select.selectByValue(Value);
			break;
			
		case "text":
			select.selectByVisibleText(Value);
			break;
			default:
				System.out.println("please select proper input ");
				break;
			
		
		}
	}
	
	
	public void explicitWait(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait (DriverManager.getDriver(),15);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
}
