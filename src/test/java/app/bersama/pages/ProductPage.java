package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage {

    protected WebDriver webDriver;
    public ProductPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div/div/div/div/div[3]/div[1]/div/div/button")
    private WebElement tertarikButton;

    @FindBy(xpath = "/html/body/div[3]/div/div")
    private WebElement frameOrder;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[2]/input")
    private WebElement orderField;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[3]/button")
    private WebElement setOrderButton;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/p")
    private WebElement orderMessage;

    public void userOrder() {
        Keyword.tapElement(tertarikButton);
    }

    public void setSetOrder() {
        Keyword.inputText(orderField, "500000");
        Keyword.waitElementToBeDisplayed(setOrderButton);
        Keyword.tapElement(setOrderButton);
    }

    public void setOrderMessage(String expectedMessage) {
        Keyword.waitElementToBeDisplayed(orderMessage);
        String actual = orderMessage.getText();
        Assert.assertEquals(actual, expectedMessage);
    }
}
