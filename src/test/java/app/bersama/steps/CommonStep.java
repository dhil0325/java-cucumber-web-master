package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import app.bersama.pages.HomePage;
import app.bersama.pages.LoginPage;
import app.bersama.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.Random;

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
    protected String getRandomEmailGenerator() {
        String alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder email = new StringBuilder();
        Random rndemail = new Random();
        while (email.length() < 8) {
            int index = (int) (rndemail.nextFloat() * alphanumeric.length());
            email.append(alphanumeric.charAt(index));
        }
        String RandomEmail = email.toString();
        return RandomEmail;
    }

    @When("login as {string}")
    public void loginAs (String credentialType) {

        String userName = "";
        String password = "";

        switch (credentialType) {
            case "valid_user1":
                userName = "lageming54@gmail.com";
                password = "fadhil45";
                break;

            case "valid_user2":
                userName = "frozt.fadhil@gmail.com";
                password = "fadhil45";
                break;

            case "invalid_user":
                userName = getRandomEmailGenerator() + "@gmail.com";
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
        HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
        homePage.validateLogin();
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


    @Then("user take screenshot full page with name {string}")
    public void userTakeScreenshotFullPageWithName(String fileName) {
        Keyword.takeScreenshot(fileName);
    }
}
