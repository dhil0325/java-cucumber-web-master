@logout
Feature: Logout

  @logout @positive
  Scenario: As a user i should be able to login
    Given navigate to url "https://secondhand-store.herokuapp.com/"
    * login as "valid_user"
    When click button logout
    Then current url should be "https://secondhand-store.herokuapp.com/"
    * user take screenshot full page with name "positive_logout_001"