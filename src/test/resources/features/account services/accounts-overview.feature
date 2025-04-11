Feature: Accounts Overview
  @OpenAccount
  Scenario: View account balances and details
    Given John is logged into the ParaBank application
    When he navigates to the Accounts Overview page
    Then he should see a list of accounts with balances

  Scenario: Account table should have rows and non-empty columns
    Given John is logged into the ParaBank application
    When he navigates to the Accounts Overview page
    Then each account row should have non-empty values