package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class InfoPenawarPage {
    protected WebDriver webDriver;

    public InfoPenawarPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]")
    private WebElement infoProductSeller;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div[2]/div[2]/div/button[2]")
    private WebElement acceptButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div[2]/div[2]/div/button[1]")
    private WebElement ignoreButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]")
    private WebElement snackBarNotification;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/p")
    private WebElement acceptNotificationText;

    public void setAcceptButton() {
        Keyword.waitElementToBeDisplayed(infoProductSeller);
        Keyword.tapElement(acceptButton);
    }

    public void setIgnoreButton() {
        Keyword.waitElementToBeDisplayed(infoProductSeller);
        Keyword.tapElement(ignoreButton);
    }

    public void setSnackBarNotification(String expectedMessage) {
        Keyword.waitElementToBeDisplayed(snackBarNotification);
        String actual = acceptNotificationText.getText();
        Assert.assertEquals(actual, expectedMessage);
    }
}
