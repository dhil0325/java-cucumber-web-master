@register
  Feature: Register
    @register @positive
    Scenario Outline: As a user i should be able to register
      Given navigate to url "https://secondhand-store.herokuapp.com/"
#      * user take screenshot full page with name "positive_register_001"
      * navigate to register page
#      * user take screenshot full page with name "positive_register_002"
      When fill form register and click register "valid_register"
#      * user take screenshot full page with name "positive_register_003"
      Then see verification alert with value "<verifMessage>"
      * user take screenshot full page with name "positive_register_004"

    Examples:
      | verifMessage                                                  |  |
      | Silahkan verifikasi email agar dapat menggunakan layanan kami |  |
