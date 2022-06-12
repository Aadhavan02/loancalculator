

Feature: To Verify Loan Details Page
  

    
    Scenario: To Check Loan Estimate
    Given Navigate to the Loan Calculator Page
    And Fill up the required details
    When Click on work out button
    Then Validate the Loan Estimate
    
     
    Scenario: To Check the Start Overbtn function
    Given Navigate to the Loan Calculator Page
    And Fill up all details
    When Click on Start Over
    Then Validate the field values
    
    
    Scenario: To Verify the Loan denial message 
    Given Navigate to the Loan Calculator Page
    And Fill up Monthly Living expense alone
    When Click work out button
    Then Verify the error message
  