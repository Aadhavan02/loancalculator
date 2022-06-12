package com.anz.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanEstimatePage {
	
	
	private static LoanEstimatePage loaninstance;
	
	private LoanEstimatePage () {
		
	}
	
	
	public static LoanEstimatePage getInstance() {
		
		if(loaninstance==null) {
			 loaninstance = new LoanEstimatePage ();
		}
		return loaninstance;
		
	}
	
	@FindBy(xpath="//*[@aria-describedby='q2q1i1 q2q1i2']")
	private  WebElement ANNUAL_INCOME;
	
	
	@FindBy(xpath="//*[@aria-describedby='q2q2i1 q2q2i2']")
	private  WebElement ANNUAL_OTHER_INCOME;
	
	
	@FindBy(xpath="//*[@aria-describedby='q3q1i1 q3q1i2']")
	private  WebElement MONTHLY_LIVING_EXPENSE;
	
	@FindBy(xpath="//*[@aria-describedby='q3q2i1 q3q2i2']")
	private  WebElement CURRENT_HOME_LOAN_REPAYMENT;
	
	
	@FindBy(xpath="//*[@aria-describedby='q3q3i1 q3q3i2']")
	private  WebElement OTHER_LOAN_MONTHLY_PAYMENT;
	
	@FindBy(xpath="//*[@aria-describedby='q3q4i1 q3q4i2']")
	private  WebElement OTHER_MONTHLY_COMMITMENTS;
	
	
	@FindBy(xpath="//*[@aria-describedby='q3q5i1']")
	private  WebElement CREDIT_CARD_LIMITS;
	
	
	@FindBy(id="btnBorrowCalculater")
	private  WebElement BORROW;

	
	@FindBy(id="borrowResultTextAmount")
	private WebElement LOANAMOUNT;
	
	@FindBy(xpath="//*[@class='start-over'][1]")
	private WebElement StartOver;
	
	@FindBy(xpath = "//*[@class='borrow__error__text']")
	private WebElement borrow_error_message;
	

/*	public WebElement getMONTHLY_LIVING_EXPENSE() {
		return MONTHLY_LIVING_EXPENSE;
	}

	public WebElement getOTHER_LOAN() {
		return OTHER_LOAN;
	}

	public WebElement getBORROW() {
		return BORROW;
	}
	
	public WebElement getANNUAL_INCOME() {
		return ANNUAL_INCOME;
	}
	*/
	
	public void clickBorrowbtn() {
		
		
		BORROW.click();
		
	}
	
	public void enterAnnualIncome(String Annualincome) {
		
		try {
			ANNUAL_INCOME.sendKeys(Annualincome);
		} catch (Exception e) {
			
			e.printStackTrace(); 
			
			
		}
		
	}
	
	
	public String getLoanEstimateValue() {
		
		
		String val = LOANAMOUNT.getText();
		return val;
	}
	
	public void enterotherAnnualIncome(String otherannualincome) {
		ANNUAL_OTHER_INCOME.sendKeys(otherannualincome);
		
	}
	
	public void enterAlldetails(String Annualincome, 
			String otherannualincome, 
			String monthlyexpense,
			String currenthomeloan,
			String otherloanmonthlypayment,
			String othermonthlycommitments,
			String creditcardlimits)
	{
		
		ANNUAL_INCOME.sendKeys(Annualincome);
		ANNUAL_OTHER_INCOME.sendKeys(otherannualincome);
		MONTHLY_LIVING_EXPENSE.sendKeys(monthlyexpense);
		CURRENT_HOME_LOAN_REPAYMENT.sendKeys(currenthomeloan);
		OTHER_LOAN_MONTHLY_PAYMENT.sendKeys(otherloanmonthlypayment);
		OTHER_MONTHLY_COMMITMENTS.sendKeys(othermonthlycommitments);
		CREDIT_CARD_LIMITS.sendKeys(creditcardlimits);
		
		
	}
	
	public void clickStartOver() {
		
		StartOver.click();
		
	}
	
	public void enterMonthlyLivingExpensealone() {
		
		MONTHLY_LIVING_EXPENSE.sendKeys("1");
		
	}
	
	public String getErrormessage() {
		
	String 	message = borrow_error_message.getText();
	return message;
		
	}
	
	
	public boolean verifyDefaultvalues() {
		
		boolean status = false;
		
	String a = ANNUAL_INCOME.getAttribute("value");
	String b = ANNUAL_OTHER_INCOME.getAttribute("value");
	
	String c =	MONTHLY_LIVING_EXPENSE.getAttribute("value");
	String d =	CURRENT_HOME_LOAN_REPAYMENT.getAttribute("value");
	String e =	OTHER_LOAN_MONTHLY_PAYMENT.getAttribute("value");
	String f =	OTHER_MONTHLY_COMMITMENTS.getAttribute("value");
	String g =	CREDIT_CARD_LIMITS.getAttribute("value");
	String h =	LOANAMOUNT.getText();
    String h1 =	h.replace("$", "");
    

	String ar [] = {a,b,c,d,e,f,g,h1};
	
	String exp = "0";
	
	for( String s: ar) {
		
		//System.out.println(s);
		
		if(s.equals(exp)) {
			
			 status = true;
			
		}
		else status= false;
		
	}
	
	return status;
	
	
	}

}
