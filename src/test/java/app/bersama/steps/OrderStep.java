package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.HomePage;
import app.bersama.pages.LoginPage;
import app.bersama.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderStep {


    @Given("select product to order")
    public void selectProductToOrder() {
        HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
        homePage.orderProduct();
    }


    @Given("order product")
    public void orderProduct() {
        ProductPage productPage = new ProductPage(DriverManager.getInstance().getDriver());
        productPage.userOrder();
    }

    @When("click button send order")
    public void clickButtonSendOrder() {
        ProductPage productPage = new ProductPage(DriverManager.getInstance().getDriver());
        productPage.setSetOrder();
    }

    @Then("see order notification {string}")
    public void seeOrderNotification(String value) {
        new ProductPage(DriverManager.getInstance().getDriver()).
                setOrderMessage(value);
    }
}



