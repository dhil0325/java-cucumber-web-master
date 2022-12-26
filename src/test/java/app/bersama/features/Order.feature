@order
Feature: Order

  @order @positive
  Scenario Outline: As a user i should be able to order product3
    Given navigate to url "https://secondhand-store.herokuapp.com/"
    * login as "valid_user"
    * current url should be "https://secondhand-store.herokuapp.com/login"
    Given select product to order
    Given order product
    When click button send order
    Then see order notification "<orderDone>"

  Examples:
    | orderDone                                                                                     |  |
    | Harga tawaranmu akan diketahui penual, jika penjual cocok kamu akan segera dihubungi penjual. |  |


