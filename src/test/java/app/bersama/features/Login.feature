@login
Feature: Login

  @login @positive
  Scenario: As a user i should be able to login
    Given navigate to url "https://secondhand-store.herokuapp.com/"
    When login as "valid_user"
    Then current url should be "https://secondhand-store.herokuapp.com/login"

  @login @negative
  Scenario Outline: As user i want to login with invalid credential
    Given navigate to url "https://secondhand-store.herokuapp.com/"
    When login as "invalid_user"
    Then see alert notification "<errorMessage>"

  Examples:
    | errorMessage         |  |
    | Akun tidak ditemukan |  |


