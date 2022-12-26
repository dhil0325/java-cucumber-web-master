@acceptorder
Feature: Accept Order
  @acceptorder @positive
  Scenario Outline: As a user i should be able to accept order
    Given navigate to url "https://secondhand-store.herokuapp.com/"
    * login as "valid_user"
    * current url should be "https://secondhand-store.herokuapp.com/login"
    * check list daftar jual
    When want to accept offer
    Then see accept order notification "<orderAccept>"
    * user take screenshot full page with name "positive_acceptorder_001"

  Examples:
      | orderAccept             |  |
      | Tawaran produk diterima |  |