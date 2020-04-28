Feature: Bank Operations
  The bank gives credit offers to business and economy customers

  Scenario: Addition of user to economy credit offer
    Given a economy credit offer
    When we add a regular customer
    Then you have new customer on economy credit offer list

  Scenario: Removal of user from economy credit offer
    Given a economy credit offer
    When we add a regular customer
    And remove a regular customer
    Then you have nobody on credit offer list