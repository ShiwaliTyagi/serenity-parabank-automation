Feature: Login to ParaBank

  As a registered ParaBank user
  I want to log in with my username and password
  So that I can access my account dashboard

  Scenario: Successful login with valid credentials
    Given the user is on the ParaBank login page
    When the user logs in with username "shiwi" and password "India@123"
    Then the user should see the account overview page
