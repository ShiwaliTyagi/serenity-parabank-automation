Feature: Fund Transfer

  @fundtransactions
  Scenario: Successfully transfer funds to a newly created savings account
    Given John is logged into the ParaBank application
    When he opens a new Savings account with a source account
    And he has transferred "10" to a new savings account
    Then he should see a confirmation message for the fund transfer
