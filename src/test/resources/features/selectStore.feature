Feature: Select a store

  @helloOptimus @Sanity @fail
  Scenario Outline: Change store by pin code of the location
    And user chooses to get started
    And user chooses to skip login
    And user allows required permissions
    And user chooses to change store
    And user enters the <pincode> and selects a store
    Then user verifies the store title

    Examples:
      | pincode |
      | 56003   |


