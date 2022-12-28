package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import app.bersama.pages.HomePage;
import app.bersama.pages.LoginPage;
import app.bersama.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStep {
    @Given("navigate to register page")
    public void navigate_to_register_page() {
        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.userRegister();
    }

    @When("fill form register and click register {string}")
    public void fillFormRegisterAndClickRegister(String registerType) {


        String nama = "";
        String email = "";
        String password = "";

        switch (registerType) {
            case "valid_register":
                nama = "Fadhil";
                email = "fadhil05856@gmail.com";
                password = "fadhil45";
                break;

            case "registered_email":
                nama = "Fadhil";
                email = "fadhil589646@gmail.com";
                password = "fadhil45";
                break;


            default:
                throw new RuntimeException("credential type doesn't exist");
        }

        RegisterPage registerPage = new RegisterPage(DriverManager.getInstance().getDriver());
        registerPage.userRegister(nama, email, password);
    }

    @Then("see verification alert with value {string}")
    public void seeVerificationAlertWithValue(String value) {
        new RegisterPage(DriverManager.getInstance().getDriver()).
                verifyMessage(value);
    }

    @Then("see verification error alert with value {string}")
    public void seeVerificationErrorAlertWithValue(String value) {
            new RegisterPage(DriverManager.getInstance().getDriver()).
                    setGetSnackbarErrorMessage(value);
    }
}
