Feature: n11 app login feature
  User Story:
  As a user, I should be able to login with correct credentials

  @wip
  Scenario: Home page title verification
    When user is on n11 home page
    Then user should see title contains n11


  @wip
  Scenario: Login as user
    Given user clicks on sign in
    When user sign in with Facebook credentials
    Then user should be logged in
