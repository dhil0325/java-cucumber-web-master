package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage {

    protected WebDriver webDriver;

    public RegisterPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "inputAddress")
    private WebElement namaField;

    @FindBy(id = "exampleInputEmail1")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='exampleInputPassword1 ']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='root']/div/div/div[2]/form/button")
    private WebElement buttonRegister;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/form/div[1]/strong")
    private WebElement verifMessage;

    public void userRegister(String nama, String email, String password) {
        Keyword.inputText(namaField, nama);
        Keyword.inputText(emailField, email);
        Keyword.inputText(passwordField, password);
        Keyword.tapElement(buttonRegister);
    }

    public void verifyMessage(String expectedMessage) {
        Keyword.waitElementToBeDisplayed(verifMessage);
        String actual = verifMessage.getText();
        Assert.assertEquals(actual, expectedMessage);
    }
}
