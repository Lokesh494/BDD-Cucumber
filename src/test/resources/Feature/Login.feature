@Login @Regression
Feature: login/logout capability

  Scenario: Login with valid credential
    Given I am on login page
    When I provide valid valid credentials
      |username|standard_user|
      |password|secret_sauce|
    And I click on login button
    Then I should be logged in successfully

  Scenario: Logout
    Given I have logged into application
    When I click on logout button
    Then I should be logged out successfully

    Scenario Outline: Login with invalid credential
      Given I am on login page
      When I provide invalid valid credentials <Username> and <Password>
      And I click on login button
      Then I should get error message <ErrorMessage>

      Examples:
      |Username				|Password				|ErrorMessage|
      |        				|        				|Epic sadface: Username is required|
      |        				|secret_sauce		|Epic sadface: Username is required|
      |standard_user	|       				|Epic sadface: Password is required|
      |standard_user	|WrongPwd				|Epic sadface: Username and password do not match any user in this service|
      |locked_out_user|secret_sauce	|Epic sadface: Sorry, this user has been locked out.|
