@login
Feature: Login

  @login @positive
  Scenario: As a user i should be able to login
    Given navigate to url "https://secondhand-store.herokuapp.com/"
    When login as "valid_user1"
    Then current url should be "https://secondhand-store.herokuapp.com/login"
    * user take screenshot full page with name "positive_login_001"


  @login @negative
  Scenario Outline: As user i want to login with invalid credential
    Given navigate to url "https://secondhand-store.herokuapp.com/"
    When login as "invalid_user"
    Then see alert notification "<errorMessage>"
    * user take screenshot full page with name "negative_login_001"

  Examples:
    | errorMessage         |  |
    | Akun tidak ditemukan |  |


