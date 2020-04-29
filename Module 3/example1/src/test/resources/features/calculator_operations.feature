Feature: Calculator Operations
  The calculator executes mathematical operations

  Scenario: Addition using the calculator
    Given a calculator
    When you add 4 and 5
    Then you obtain the sum 9

  Scenario: Another addition using the calculator
    Given a calculator
    When you add 12 and 3
    Then you obtain the sum 15