package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitDriver {

    private static String browser;

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public void driverInit() {
        OptionsManager optionsManager = new OptionsManager();
        PropertyUtil propUtil = new PropertyUtil();
        try {
            browser = propUtil.getGlobalProperty("browser");
        } catch (Exception e) {
            System.out.println("Could not get global property " + e.getCause());
        }
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(optionsManager.getChromeOptions()));
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.iedriver().setup();
            driver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
        } else {
            System.out.println("Please provide valid browser");
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void tearDown() {
        getDriver().close();
    }
}
