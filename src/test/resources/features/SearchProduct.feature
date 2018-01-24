Feature: Tests on target app

  @helloOptimus
  Scenario: Search for a product and view the product in detail
    And user chooses to get started
    And user chooses to skip login
    And user allows required permissions
    And user searches by text
    Then user verifies search results

