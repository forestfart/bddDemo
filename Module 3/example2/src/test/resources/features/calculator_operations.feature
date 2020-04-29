Feature: Calculator Operations
  The calculator executes mathematical operations

  Scenario Outline: Addition using the calculator
    Given a calculator
    When you add <arg1> and <arg2>
    Then you obtain the sum <sum>

    Examples:
      | arg1 | arg2 | sum |
      |    4 |    5 |   9 |
      |   12 |    3 |  15 |