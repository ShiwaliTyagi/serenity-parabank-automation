Feature: Fund Transfer

  @fundtransactions
  Scenario: Successfully transfer funds to a newly created savings account
    Given John is logged into the ParaBank application
    When he opens a new Savings account with a source account
    And he has transferred "10" to a new savings account
    Then he should see a confirmation message for the fund transfer

  @FundTransfer
  Scenario: Successfully transfer funds and verify deduction
    Given John is logged into the ParaBank application
    And he checks and saves the current balance of account "dynamic"
    When he opens a new Savings account with a source account
    And he has transferred "10" to a new savings account
    Then he should see a confirmation message for the fund transfer
    Then the balance of account "dynamic" should be reduced by "60"
    Then the balance of account "new" should be gained by "60"