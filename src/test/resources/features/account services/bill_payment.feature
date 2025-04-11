Feature: Bill Payment
  @BillPayment
  Scenario: Successfully pay a bill
    Given John is logged into the ParaBank application
    And he navigates to the Bill Payment page
    When user pays bill with payee "ABC Corp", address "123 Street", city "Toronto", state "ON", zip "M5H 2N2", phone "1234567890", account "12345", verifyAccount "12345" with amount "100" from account "14010"
    Then user should see a success message with payee "ABC Corp", amount "100", and account "14010"
