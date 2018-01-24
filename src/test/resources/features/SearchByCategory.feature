Feature: Search by category for a particular product

  @helloOptimus
  Scenario Outline: search for products by category
    Given user is on landing page and swipes right to see all screens
    And user chooses to get started
    And user logs in with valid credentials
    And user allows required permissions
    And user selects search by category
    Then user selects <Category> products
    And user selects an Item
    Then user adds a shoe to cart
    Then user chooses to logout

    Examples:
      | Category |
      | shoes    |