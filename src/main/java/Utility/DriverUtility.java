package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtility {

    public static void timeout(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception ex) {
            System.out.println("Error in waiting" + ex);
        }
    }

}
