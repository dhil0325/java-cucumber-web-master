@register
  Feature: Register
    @register @positive
    Scenario Outline: As a user i should be able to register
      Given navigate to url "https://secondhand-store.herokuapp.com/"
      * navigate to register page
      When fill form register and click register "valid_register"
      Then see verification alert with value "<verifMessage>"
      * user take screenshot full page with name "positive_register_001"

    Examples:
      | verifMessage                                                  |  |
      | Silahkan verifikasi email agar dapat menggunakan layanan kami |  |

    @register @negative
    Scenario Outline: As a user i should not be able to register with registered email
      Given navigate to url "https://secondhand-store.herokuapp.com/"
      * navigate to register page
      When fill form register and click register "registered_email"
      Then see verification error alert with value "<errorMessage>"
      * user take screenshot full page with name "negative_register_001"

    Examples:
      | errorMessage          |  |
      | Email sudah digunakan |  |
