package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class DaftarJualPage {
    protected WebDriver webDriver;

    public DaftarJualPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div/div/button[1]/i")
    private WebElement allProductButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div/div/button[2]")
    private WebElement daftarJualButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div/div/button[3]")
    private WebElement soldProductButton;

    @FindBy(xpath = "//*[@class=\"content card\"]")
    private WebElement displaySellerProduct;


    public void tapDaftarJual() {
        Keyword.tapElement(daftarJualButton);
        Keyword.waitElementToBeDisplayed(displaySellerProduct);
        Keyword.tapElement(displaySellerProduct);
    }

}
