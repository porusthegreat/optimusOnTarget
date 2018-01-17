Feature: Search by category for a particular product

  @helloOptimus
  Scenario Outline: search for pharmaceutical products
    Given user in on landing and chooses to get started
    And user chooses to skip login
    And user allows required permissions
    And user selects search by category
    Then user selects <Category> products
    And user selects a recipe for pets
    Examples:
    | Category|
    | pets |