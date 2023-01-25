package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import app.bersama.pages.HomePage;
import app.bersama.pages.LoginPage;
import app.bersama.pages.RegisterPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;
import java.util.random.RandomGenerator;

public class RegisterStep {

    protected String getRandomEmailGenerator() {
        String alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder email = new StringBuilder();
        Random rndemail = new Random();
        while(email.length() <8) {
            int index = (int) (rndemail.nextFloat() * alphanumeric.length());
            email.append(alphanumeric.charAt(index));
        }
        String RandomEmail = email.toString();
        return RandomEmail;
    }

    protected String getRandomPassword() {
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz123456789";
        StringBuilder password = new StringBuilder();
        Random rndpass = new Random();
        while(password.length() <7) {
            int index = (int) (rndpass.nextFloat() * alphanumeric.length());
            password.append(alphanumeric.charAt(index));
        }
            String RandomPassword = password.toString();
            return RandomPassword;
    }

    public String getRandomName() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        return name;
    }


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
                nama =  getRandomName();
                email = getRandomEmailGenerator() + "@gmail.com";
                password = getRandomPassword();
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
}
