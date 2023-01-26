package app.bersama;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author regiewby on 05/12/22
 * @project java-cucumber-learning
 */
public class BrowserFactory {

    protected WebDriver webDriver;

    public WebDriver launchBrowser(String browserName) {

        // launch chrome browser
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();

        // launch headless chrome browser
        } else if (browserName.equalsIgnoreCase("headless chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("--headless");
            webDriver = new ChromeDriver(options);

        // launch firefox browser
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();

        // launch headless firefox browser
        } else if (browserName.equalsIgnoreCase("headless firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            options.addArguments("--disable-gpu");
            webDriver = new FirefoxDriver(options);
        }

        return webDriver;
    }
}
