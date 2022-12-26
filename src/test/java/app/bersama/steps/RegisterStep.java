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

    @When("fill form register and click register")
    public void fillFormRegisterAndClickRegister() {
        RegisterPage registerPage = new RegisterPage(DriverManager.getInstance().getDriver());
        registerPage.userRegister("Fadhil", "fadhil12331@gmail.com", "password321");
    }

    @Then("see verification alert with value {string}")
    public void seeVerificationAlertWithValue(String value) {
        new RegisterPage(DriverManager.getInstance().getDriver()).
                verifyMessage(value);
    }
}
