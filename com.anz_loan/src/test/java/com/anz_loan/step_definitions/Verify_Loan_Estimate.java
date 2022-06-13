package com.anz_loan.step_definitions;




import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import com.anz.constants.Constants;
import com.anz.page.objects.LoanEstimatePage;
import com.anzloan.webdriver.manager.DriverManager;



public class Verify_Loan_Estimate {
	
	
	//public static final Logger LOGGER= LogManager.getLogger(Verify_Loan_Estimate.class);
	
	@Given("Navigate to the Loan Calculator Page")
	public void navigate_to_the_loan_calculator_page() {
		
	    DriverManager.getDriver().get(Constants.APP_URL);
	    
	   
 
	}

	@Given("Fill up the required details")
	public void fill_up_the_required_details() {
		
	    LoanEstimatePage.getInstance().enterAlldetails("80000", "10000", "500", "0", "100", "0", "10000");
	    
	}

	@When("Click on work out button")
	public void click_on_work_out_button() {
		
		LoanEstimatePage.getInstance().clickBorrowbtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    
	}

	@Then("Validate the Loan Estimate")
	public void validate_the_loan_estimate() {
		
		String value =  LoanEstimatePage.getInstance().getLoanEstimateValue();
		
		System.out.println(value);
		
	    String Expected = Constants.LOAN_AMOUNT;
		
        boolean Actual= value.equalsIgnoreCase(Expected);

        Assert.assertEquals(true, Actual);
		
	
	}
	
	@Given("Fill up all details")
	public void Fill_up_all_details() {
		
	    LoanEstimatePage.getInstance().enterAlldetails("80000", "10000", "500", "10", "10", "10", "1000");
	    
	}
	
	@When("Click on Start Over")
	public void click_on_start_over() throws Exception {
		
		LoanEstimatePage.getInstance().clickBorrowbtn();
		
		Thread.sleep(3000);
		
		LoanEstimatePage.getInstance().clickStartOver();
		
	   
	}

	@Then("Validate the field values")
	public void validate_the_field_values() throws InterruptedException {
		
		Thread.sleep(3000);
		
		boolean Actual = LoanEstimatePage.getInstance().verifyDefaultvalues();
		
		Assert.assertEquals(true, Actual);
	   
	}
	
	
	@Given("Fill up Monthly Living expense alone")
	public void fill_up_monthly_living_expense_alone() {
	    
		LoanEstimatePage.getInstance().enterMonthlyLivingExpensealone();
	    
	}

	@When("Click work out button")
	public void click_work_out_button() {
		
		LoanEstimatePage.getInstance().clickBorrowbtn();
	    
	}

	@Then("Verify the error message")
	public void verify_the_error_message() {
		
		String portal = LoanEstimatePage.getInstance().getErrormessage();
		
		String msg = Constants.ERROR_MESSAGE;
		
		boolean status = portal.equals(msg);
		
		Assert.assertEquals(true, status);
		
		
	    
	}

}
