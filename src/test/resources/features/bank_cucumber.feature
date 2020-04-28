Feature: Bank Operations
  The bank gives credit offers to business and economy customers

  Scenario: Addition of user to economy credit offer
    Given a economy credit offer
    When we add a regular customer
    Then we have the customer on economy credit offer list

  Scenario: Removal of user from economy credit offer
    Given a economy credit offer
    When we add a regular customer
    And remove a regular customer
    Then we have nobody on credit offer list

  Scenario: Removal of vip user from economy credit offer
    Given a economy credit offer
    When we add a vip customer
    And remove a vip customer
    Then we have the customer on economy credit offer list

    Scenario: Addition of vip customer to business credit offer
      Given a business credit offer
      When we add a vip customer
      Then we have the customer on business credit offer list

