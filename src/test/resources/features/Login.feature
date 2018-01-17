Feature:

  @helloOptimus
  Scenario: user tries to log in with invalid credentials and faces error
    Given user in on landing and chooses to get started
    And user chooses to Login and gets error due to invalid credentials