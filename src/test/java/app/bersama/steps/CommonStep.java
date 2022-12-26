package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import app.bersama.pages.HomePage;
import app.bersama.pages.LoginPage;
import app.bersama.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.security.Key;

/**
 * @author regiewby on 05/12/22
 * @project java-cucumber-learning
 */
public class CommonStep {

    @Given("navigate to url {string}")
    public void navigateToUrl(String url) {
        Keyword.navigateToUrl(url);
        HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
        homePage.tapLogin();
    }

    @When("login as {string}")
    public void loginAs(String credentialType) {

        String userName = "";
        String password = "";

        switch (credentialType) {
            case "valid_user":
                userName = "lageming54@gmail.com";
                password = "fadhil45";
                break;

            case "invalid_user":
                userName = "asdasd@gmail.com";
                password = "password01";
                break;

            default:
                throw new RuntimeException("credential type doesn't exist");
        }

        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.userLogin(userName, password);
    }


    @Then("current url should be {string}")
    public void currentUrlShouldBe(String url) {
        Keyword.assertCurrentUrl(url);
    }

    @Then("see alert notification {string}")
    public void seeAlertNotification(String value) {
        new LoginPage(DriverManager.getInstance().getDriver()).
                    setSnackbarError(value);
    }

    @When("click button logout")
    public void clickButtonLogout() {
        HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
        homePage.userLogout();
    }

    @When("click user menu and choose profile")
    public void clickUserMenuAndChooseProfile() {
        HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
        homePage.checkProfile();
    }





}
