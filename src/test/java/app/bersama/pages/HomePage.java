package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.time.Duration;

public class HomePage {

    protected WebDriver webDriver;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id='navbarText']/ul/li/a")
    private WebElement buttonMasuk;

    @FindBy(xpath = "//*[@id='root']/div/a")
    private WebElement sellButton;

    @FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div[1]/div")
    private WebElement displayProduct;

    @FindBy(xpath = "//*[@id=\"root\"]/div/a")
    private WebElement addProduct;

    @FindBy(id = "user")
    private WebElement userMenu;

    @FindBy(id = "notification")
    private WebElement notificationBar;

    @FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[1]/a")
    private WebElement ListBar;

    @FindBy(xpath = "//*[@id='navbarText']/ul/li[3]/div/button")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[3]/div/a")
    private WebElement profileButton;

    @FindBy(xpath = "//*[@class='card-body']")
    private WebElement productDisplay;


    public void tapLogin() {
        Keyword.tapElement(buttonMasuk);
    }

    public void validateLogin() {
        Keyword.validateElementIsVisibleAndEnabled(userMenu);
    }

    public void addProduct() {
        Keyword.tapElement(addProduct);
    }

    public void userLogout() {
        Keyword.tapElement(userMenu);
        Keyword.tapElement(logoutButton);
    }

    public void checkProfile() {
        Keyword.tapElement(userMenu);
        Keyword.tapElement(profileButton);
    }

    public void orderProduct() {
        Keyword.tapElement(productDisplay);
    }
}
