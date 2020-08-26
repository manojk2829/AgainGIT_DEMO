Feature: Application Login
  
  Scenario: Login First User
    Given User is Banking Login landing page
    And Login Page displayed
    When Enter username "U" and Password "P"
    And click on Submit button
    Then Welcome page is getting opened
    And Cards are displayed "true"
    
  Scenario: Login Second User
    Given User is Banking Login landing page
    And Login Page displayed
    When Enter username "U1" and Password "P1"
    And click on Submit button
    Then Welcome page is getting opened
    And Cards are displayed "False"  