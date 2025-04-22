Feature: Simulate Data Load by creating multiple users with different roles

  @DataLoad
  Scenario: Create multiple test users before functional test execution
    Given admin triggers data load setup
    When the following users are registered:
      | firstName | lastName | username    | password  |
      | Alice     | Smith    | testuser01  | pass123   |
      | Bob       | Johnson  | testuser02  | pass456   |
      | Carol     | White    | testuser03  | pass789   |
    Then users should be created successfully
