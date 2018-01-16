Feature: Say Hello to Optimus

  @helloOptimus
  Scenario: Hello Optimus
    Given user in on landing and chooses to get started
    And user chooses to skip login
    And user allows required permissions
    And user searches by text
    Then user verifies search results

  @helloOptimus
  Scenario: Swipe on the launch screen
    Given user swipes right to see all screens