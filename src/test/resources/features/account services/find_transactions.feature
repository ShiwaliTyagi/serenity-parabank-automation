Feature: Find Transactions

  Scenario: Search transactions by amount
    Given John is logged into the ParaBank application
    When he opens a new Savings account with a source account
    And he has transferred "$10" to a new savings account
    When he searches for transactions with amount "10"
    Then he should see the transaction listed in the results