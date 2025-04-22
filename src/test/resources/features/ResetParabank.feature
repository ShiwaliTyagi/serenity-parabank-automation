Feature: Reset ParaBank Application

  @ResetBeforeTests
  Scenario: Reset the application before test execution
    Given an admin resets the application to its initial state
    Then the database should be cleaned and reset
