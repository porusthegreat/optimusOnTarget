Feature:

  @helloOptimus
  Scenario: user tries to log in with invalid credentials and faces error
    Given user is on landing page and swipes right to see all screens
    And user chooses to get started
    And user chooses to Login and gets error due to invalid credentials