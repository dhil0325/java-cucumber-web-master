package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.DaftarJualPage;
import app.bersama.pages.HomePage;
import app.bersama.pages.InfoPenawarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AcceptOrderStep {

    @Given("check list daftar jual")
    public void checkListDaftarjual() {
        HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
        homePage.tapListBar();
    }

    @When("want to accept offer")
    public void wantToAcceptOffer() {
        DaftarJualPage daftarJualPage = new DaftarJualPage(DriverManager.getInstance().getDriver());
        daftarJualPage.tapDaftarJual();

        InfoPenawarPage infoPenawarPage = new InfoPenawarPage(DriverManager.getInstance().getDriver());
        infoPenawarPage.setAcceptButton();
    }

    @Then("see accept order notification {string}")
    public void seeAcceptOrderNotification(String value) {
        new InfoPenawarPage(DriverManager.getInstance().getDriver()).
                setSnackBarNotification(value);
    }
}
