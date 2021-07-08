package Utility;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        //chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("--headless");
        return chromeOptions;
    }

    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        //firefoxOptions.addArguments("--incognito");
        //firefoxOptions.addArguments("--headless");
        return firefoxOptions;
    }

    public EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setCapability("useAutomationExtension", false);
        //options.setCapability("headless", true);
        //options.setCapability("disable-gpu", true);
        options.setCapability("start-maximized", true);
        return options;
    }
}
