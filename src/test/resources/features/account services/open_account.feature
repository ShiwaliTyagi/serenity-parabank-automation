Feature: Open a new account

  Scenario: Successfully open a new account
    Given John is logged into the ParaBank application
    When he opens a new Savings account with a source account
    Then he should see a confirmation message with the new account ID
