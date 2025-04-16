Feature: Bill Payment
  @BillPayment
  Scenario: Successfully pay a bill
    Given John is logged into the ParaBank application
    And he navigates to the Bill Payment page
    When user pays bill with payee "ABC Corp", address "123 Street", city "Toronto", state "ON", zip "M5H 2N2", phone "1234567890", account "12345", verifyAccount "12345" with amount "100" from account "dynamic"
    Then user should see a success message with payee "ABC Corp", amount "100", and account "dynamic"

  @BillPaymentBalanceCheck
  Scenario: Pay a bill and verify account balance deduction
    Given John is logged into the ParaBank application
    And he checks and saves the current balance of account "dynamic"
    And he navigates to the Bill Payment page
    When user pays bill with payee "XYZ Ltd", address "456 Lane", city "Ottawa", state "ON", zip "K1A 0B1", phone "9876543210", account "12345", verifyAccount "12345" with amount "50" from account "dynamic"
    Then the balance of account "dynamic" should be reduced by "50"

