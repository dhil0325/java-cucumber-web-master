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
