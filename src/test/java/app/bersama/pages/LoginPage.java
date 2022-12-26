package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.security.Key;
import java.time.Duration;

/**
 * @author regiewby on 02/12/22
 * @project java-cucumber-learning
 */
public class LoginPage {

    protected WebDriver webDriver;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "exampleInputEmail1")
    private WebElement emailField;

    @FindBy(xpath= "//*[@id='exampleInputPassword1 ']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='root']/div/div/div[2]/form/button")
    private WebElement buttonMasuk;

    @FindBy(xpath = "//*[@id='root']/div/div/div[2]/form/p/a")
    private WebElement navLinkRegister;

    @FindBy(xpath = "//*[@id='root']/div/div/div[2]/form/div[1]/p")
    private WebElement snackbarError;

    public void userLogin(String userName, String password) {
    Keyword.inputText(emailField, userName);
    Keyword.inputText(passwordField, password);
    Keyword.tapElement(buttonMasuk);
    }

    public void userRegister() {
        Keyword.tapElement(navLinkRegister);
    }

    public void setSnackbarError(String expectedMessage) {
        Keyword.waitElementToBeDisplayed(snackbarError);
        String actual = snackbarError.getText();
        Assert.assertEquals(actual, expectedMessage);
    }
}
