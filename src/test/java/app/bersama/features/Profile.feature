@profile
Feature: Profile

  @profile @positive
  Scenario: As a user i should be able to see profile
    Given navigate to url "https://secondhand-store.herokuapp.com/"
    * login as "valid_user"
    When click user menu and choose profile
    Then current url should be "https://secondhand-store.herokuapp.com/profile"

  @editprofile
  Scenario: As a user i should be able to see profile
    Given navigate to url "https://secondhand-store.herokuapp.com/"
    * login as "valid_user"
    When click user menu and choose profile
    Then current url should be "https://secondhand-store.herokuapp.com/profile"