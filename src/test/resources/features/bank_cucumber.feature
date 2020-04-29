Feature: Bank Operations
  The bank gives credit offers to business and economy customers

  Scenario Outline: Addition of a customer to a credit offer
    Given a "<creditOfferType>" credit offer
    When we add a "<customerType>" customer
    Then we have the <creditOfferListCount> customers on "<expectedOfferType>" credit offer list

    Examples:
      | creditOfferType | customerType | creditOfferListCount | expectedOfferType |
      | economy         | regular      | 1                    | Economy           |
      | business        | vip          | 1                    | Business          |
      | business        | regular      | 0                    | Business          |
      | premium         | regular      | 0                    | Premium           |
      | premium         | vip          | 1                    | Premium           |

  Scenario Outline:
    Given a "<creditOfferType>" credit offer
    When we add a "<customerType>" customer
    And remove a "<customerType>" customer
    Then we have the <creditOfferListCount> customers on "<expectedOfferType>" credit offer list

    Examples:
      | creditOfferType | customerType | creditOfferListCount | expectedOfferType |
      | economy         | regular      | 0                    | Economy           |
      | economy         | vip          | 1                    | Economy           |
      | premium         | vip          | 0                    | Premium           |

  Scenario Outline: a customer cannot be assigned to a credit offer more than once
    Given a "<creditOfferType>" credit offer
    When we add a "<customerType>" customer
    And we add a "<customerType>" customer
    Then we have the <creditOfferListCount> customers on a credit offer list

    Examples:
      | creditOfferType | customerType | creditOfferListCount |
      | economy         | regular      | 1                    |
      | business        | vip          | 1                    |
      | premium         | vip          | 1                    |
