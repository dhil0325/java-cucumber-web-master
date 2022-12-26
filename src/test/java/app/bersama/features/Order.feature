@order
Feature: Order

  @order @positive
  Scenario Outline: As a user i should be able to order product3
    Given navigate to url "https://secondhand-store.herokuapp.com/"
    * login as "valid_user"
    * current url should be "https://secondhand-store.herokuapp.com/login"
    * select product to order
    * order product
    When click button send order
    Then see order notification "<orderDone>"
    * user take screenshot full page with name "positive_order_001"

  Examples:
    | orderDone                                                                                     |  |
    | Harga tawaranmu akan diketahui penual, jika penjual cocok kamu akan segera dihubungi penjual. |  |


