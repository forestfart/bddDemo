Feature: Bank Operations
  The bank gives credit offers to business and economy customers

  Scenario: Addition of user to economy credit offer
    Given a "economy" credit offer
    When we add a regular customer
    Then we have the 1 customer on "Economy" credit offer list

  Scenario: Removal of user from economy credit offer
    Given a "economy" credit offer
    When we add a regular customer
    And remove a regular customer
    Then we have the 0 customer on "Economy" credit offer list

  Scenario: Removal of vip user from economy credit offer
    Given a "economy" credit offer
    When we add a vip customer
    And remove a vip customer
    Then we have the 1 customer on "Economy" credit offer list

  Scenario: Addition of vip customer to business credit offer
    Given a "business" credit offer
    When we add a vip customer
    Then we have the 1 customer on "Business" credit offer list

  Scenario: Addition of regular customer to business credit offer
    Given a "business" credit offer
    When we add a regular customer
    Then we have the 0 customer on "Business" credit offer list

  Scenario: Addition of vip customer to premium credit offer
    Given a "premium" credit offer
    When we add a regular customer
    Then we have the 0 customer on "Premium" credit offer list

  Scenario: Addition of vip customer to premium credit offer
    Given a "premium" credit offer
    When we add a vip customer
    Then we have the 1 customer on "Premium" credit offer list

  Scenario: Removal of vip user from premium credit offer
    Given a "premium" credit offer
    When we add a vip customer
    And remove a vip customer
    Then we have the 0 customer on "Premium" credit offer list