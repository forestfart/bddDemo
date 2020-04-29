Feature: Bank Operations
  The bank gives credit offers to business and economy customers

  Scenario Outline: Addition of a customer to a credit offer
    Given a "<creditOfferType>" credit offer of an "100000.00"
    When we add a "<type>" customer
    Then we have the <creditOfferListCount> customers on "<expectedOfferType>" credit offer list

    Examples:
      | creditOfferType | type    | creditOfferListCount | expectedOfferType |
      | economy         | regular | 1                    | Economy           |
      | business        | vip     | 1                    | Business          |
      | business        | regular | 0                    | Business          |
      | premium         | regular | 0                    | Premium           |
      | premium         | vip     | 1                    | Premium           |

  Scenario Outline: Removal of a customer from a credit offer
    Given a "<creditOfferType>" credit offer of an "100000.00"
    When we add a "<type>" customer
    And remove a "<type>" customer
    Then we have the <creditOfferListCount> customers on "<expectedOfferType>" credit offer list

    Examples:
      | creditOfferType | type    | creditOfferListCount | expectedOfferType |
      | economy         | regular | 0                    | Economy           |
      | economy         | vip     | 1                    | Economy           |
      | premium         | vip     | 0                    | Premium           |

  Scenario Outline: A customer cannot be assigned to a credit offer more than once
    Given a "<creditOfferType>" credit offer of an "100000.00"
    When we add a "<type>" customer
    And we add a "<type>" customer
    Then we have the <creditOfferListCount> customers on a credit offer list

    Examples:
      | creditOfferType | type    | creditOfferListCount |
      | economy         | regular | 1                    |
      | business        | vip     | 1                    |
      | premium         | vip     | 1                    |

  Scenario Outline: A customer may receive bonus points depending on the amount of credit offer
    Given a "economy" credit offer of an "<amount>"
    When we add a "<type>" customer
    Then "<type>" customer receives <bonusPoints>

    Examples:
      | amount    | type    | bonusPoints |
      | 100000.00 | regular | 5000        |
      | 100000.00 | vip     | 10000       |
